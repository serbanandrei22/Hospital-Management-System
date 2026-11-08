package com.example.hospital.controller;
import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }
    @GetMapping("/patient")
    public String listPatients(Model model){
        model.addAttribute("patients",patientService.getAllPatients());
        return "patient/index";
    }
    @GetMapping("/patient/new")
    public String showCreateForm(Model model){
        model.addAttribute("patient",new Patient());
        return "patient/form";
    }
    @PostMapping("/patient")
    public String createPatient(@ModelAttribute Patient patient){
        patientService.savePatient(patient);
        return "redirect:/patient";
    }
    @PostMapping("/patient/delete")
    public String deletePatient(@PathVariable String id){
        patientService.deletePatient(id);
        return "redirect:/patient";
    }
}
