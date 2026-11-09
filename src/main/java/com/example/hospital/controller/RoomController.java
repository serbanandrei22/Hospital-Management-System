package com.example.hospital.controller;

import com.example.hospital.model.Room;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.hospital.service.RoomService;
@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;}

    @GetMapping
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "room/index";}

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("statuses", Room.RoomStatus.values());
        return "room/form";
    }

    @PostMapping
    public String createRoom(@ModelAttribute Room room) {
        roomService.saveRoom(room);
        return "redirect:/room";
    }

    @PostMapping("/{id}/delete")
    public String deleteRoom(@PathVariable String id) {
        roomService.deleteRoom(id);
        return "redirect:/room";
    }
}