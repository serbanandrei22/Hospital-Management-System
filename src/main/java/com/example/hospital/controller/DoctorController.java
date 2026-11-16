package com.example.hospital.controller;

import com.example.hospital.model.Doctor;
import com.example.hospital.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctor/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/form";
    }

    @PostMapping
    public String createDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctor";
    }
    @GetMapping("/{id}")
    public String showDoctorDetails(@PathVariable String id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) return "redirect:/doctor";
        model.addAttribute("doctor", doctor);
        return "doctor/details";
    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) return "redirect:/doctor";
        model.addAttribute("doctor", doctor);
        return "doctor/form";
    }

    @PostMapping("/{id}/delete")
    public String deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctor";
    }
}