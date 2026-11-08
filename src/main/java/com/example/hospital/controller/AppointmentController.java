package com.example.hospital.controller;
import com.example.hospital.model.Appointment;
import com.example.hospital.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService=appointmentService;
    }
    @GetMapping
    public String listAppointments(Model model){
        model.addAttribute("appointments",appointmentService.getAllAppointments());
        return "appointment/index";
    }
    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("appointment",new Appointment());
        return "appointment/form";
    }
    @PostMapping
    public String createAppointment(@ModelAttribute Appointment appointment){
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointment";
    }
    @PostMapping("/delete")
    public String deleteAppointment(@PathVariable String id){
        appointmentService.deleteAppointment(id);
        return "redirect:/appointment";
    }
}
