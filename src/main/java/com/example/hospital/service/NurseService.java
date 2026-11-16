package com.example.hospital.service;

import com.example.hospital.model.Nurse;
import com.example.hospital.model.Department;
import com.example.hospital.repository.NurseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {
    private final NurseRepository nurseRepository;
    private final DepartmentService departmentService;

    public NurseService(NurseRepository nurseRepository,DepartmentService departmentService) {
        this.nurseRepository = nurseRepository;
        this.departmentService=departmentService;
    }

    public void saveNurse(Nurse nurse) {
        if (nurse.getDepartmentId() != null && !nurse.getDepartmentId().isEmpty()) {
            Department d = departmentService.getDepartmentById(nurse.getDepartmentId());
            if (d == null) {
                throw new IllegalArgumentException("Eroare: Departamentul cu ID-ul " + nurse.getDepartmentId() + " nu exista!");
            }
        }
        nurseRepository.save(nurse);
    }

    public Nurse getNurseById(String id) {
        return nurseRepository.findById(id);
    }

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public void deleteNurse(String id) {
        nurseRepository.delete(id);
    }
}