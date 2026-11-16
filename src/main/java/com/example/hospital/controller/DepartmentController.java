package com.example.hospital.controller;
import com.example.hospital.model.Department;
import com.example.hospital.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }
    @GetMapping
    public String listDepartments(Model model){
        model.addAttribute("departments",departmentService.getAllDepartments());
        return "department/index";
    }
    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("department", new Department());
        return "department/form";
    }
    @PostMapping
    public String createDepartment(@ModelAttribute Department department, Model model) {
        try {
            departmentService.saveDepartment(department);
            return "redirect:/department";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("department", department);
            return "department/form";
        }
    }
    @GetMapping("/{id}")
    public String showDepartmentDetails(@PathVariable String id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        if (department == null) return "redirect:/department";
        model.addAttribute("department", department);
        return "department/details";
    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        if (department == null) return "redirect:/department";
        model.addAttribute("department", department);
        return "department/form";
    }
    @PostMapping("/{id}/delete")
    public String deleteDepartment(@PathVariable String id){
        departmentService.deleteDepartment(id);
        return "redirect:/department";
    }
}
