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
        model.addAttribute("statuses", Appointment.AppointmentStatus.values());
        return "appointment/form";
    }
    @PostMapping
    public String createAppointment(@ModelAttribute Appointment appointment, Model model){
        try {
            appointmentService.saveAppointment(appointment);
            return "redirect:/appointment";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("appointment", appointment);
            model.addAttribute("statuses", Appointment.AppointmentStatus.values());
            return "appointment/form";
        }
    }
    @GetMapping("/{id}")
    public String showAppointmentDetails(@PathVariable String id, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment == null) return "redirect:/appointment";
        model.addAttribute("appointment", appointment);
        return "appointment/details";
    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment == null) return "redirect:/appointment";
        model.addAttribute("appointment", appointment);
        model.addAttribute("statuses", Appointment.AppointmentStatus.values());
        return "appointment/form";
    }
    @PostMapping("/{id}/delete")
    public String deleteAppointment(@PathVariable String id){
        appointmentService.deleteAppointment(id);
        return "redirect:/appointment";
    }
}
