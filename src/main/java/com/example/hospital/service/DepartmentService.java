package com.example.hospital.service;
import com.example.hospital.model.Department;
import com.example.hospital.model.Hospital;
import com.example.hospital.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final HospitalService hospitalService;
    public DepartmentService(DepartmentRepository departmentRepository,HospitalService hospitalService){
        this.departmentRepository=departmentRepository;
        this.hospitalService=hospitalService;
    }
    public void saveDepartment(Department department){
        if (department.getHospitalId() != null && !department.getHospitalId().isEmpty()) {
            Hospital h = hospitalService.getHospitalById(department.getHospitalId());
            if (h == null) {
                throw new IllegalArgumentException("Eroare: Spitalul cu ID-ul " + department.getHospitalId() + " nu există!");
            }
        }
        departmentRepository.save(department);
    }
    public Department getDepartmentById(String id){
        return departmentRepository.findById(id);
    }
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
    public void deleteDepartment(String id){
        departmentRepository.delete(id);
    }

}
