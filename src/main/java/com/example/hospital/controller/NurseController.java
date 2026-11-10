package com.example.hospital.controller;
import com.example.hospital.model.Nurse;
import com.example.hospital.service.NurseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nurse")
public class NurseController {
    private final NurseService nurseService;
    public NurseController(NurseService nurseService){
        this.nurseService=nurseService;
    }
    @GetMapping
    public String listNurses(Model model){
        model.addAttribute("nurses",nurseService.getAllNurses());
        return "nurse/index";
    }
    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("nurse", new Nurse());
        model.addAttribute("statuses",Nurse.QualificationLevel.values());
        return "nurse/form";
    }
    @PostMapping
    public String createNurse(@ModelAttribute Nurse nurse){
        nurseService.saveNurse(nurse);
        return "redirect:/nurse";
    }
    @PostMapping("/{id}/delete")
    public String deleteNurse(@PathVariable String id){
        nurseService.deleteNurse(id);
        return "redirect:/nurse";
    }
}
