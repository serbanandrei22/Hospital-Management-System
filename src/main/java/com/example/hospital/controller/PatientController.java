package com.example.hospital.controller;
import com.example.hospital.model.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }
    @GetMapping
    public String listPatients(Model model){
        model.addAttribute("patients",patientService.getAllPatients());
        return "patient/index";
    }
    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("patient",new Patient());
        return "patient/form";
    }
    @PostMapping
    public String createPatient(@ModelAttribute Patient patient){
        patientService.savePatient(patient);
        return "redirect:/patient";
    }
    @GetMapping("/{id}")
    public String showPatientDetails(@PathVariable String id, Model model) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) return "redirect:/patient";
        model.addAttribute("patient", patient);
        return "patient/details";
    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) return "redirect:/patient";
        model.addAttribute("patient", patient);
        return "patient/form";
    }
    @PostMapping("/{id}/delete")
    public String deletePatient(@PathVariable String id){
        patientService.deletePatient(id);
        return "redirect:/patient";
    }
}
