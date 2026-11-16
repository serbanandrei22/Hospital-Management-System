package com.example.hospital.service;

import com.example.hospital.model.Doctor;
import com.example.hospital.model.Department;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DepartmentService departmentService;

    public DoctorService(DoctorRepository doctorRepository,DepartmentService departmentService){
        this.doctorRepository=doctorRepository;
        this.departmentService=departmentService;
    }
    public void saveDoctor(Doctor doctor){
        if (doctor.getDepartmentId() != null && !doctor.getDepartmentId().isEmpty()) {
            Department d = departmentService.getDepartmentById(doctor.getDepartmentId());
            if (d == null) {
                throw new IllegalArgumentException("Eroare: Departamentul cu ID-ul " + doctor.getDepartmentId() + " nu exista!");
            }
        }
        doctorRepository.save(doctor);
    }
    public Doctor getDoctorById(String id){
        return doctorRepository.findById(id);
    }
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    public void deleteDoctor(String id){
        doctorRepository.delete(id);
    }
}
