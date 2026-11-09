package com.example.hospital.controller;

import com.example.hospital.model.Hospital;
import com.example.hospital.service.HospitalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    public String listHospitals(Model model) {
        model.addAttribute("hospitals", hospitalService.getAllHospital());
        return "hospital/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("hospital", new Hospital());
        return "hospital/form";
    }

    @PostMapping
    public String createHospital(@ModelAttribute Hospital hospital) {
        hospitalService.saveHospital(hospital);
        return "redirect:/hospital";
    }

    @PostMapping("/{id}/delete")
    public String deleteHospital(@PathVariable String id) {
        hospitalService.deleteHospital(id);
        return "redirect:/hospital";
    }
}