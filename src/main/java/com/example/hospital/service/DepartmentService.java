package com.example.hospital.service;
import com.example.hospital.model.Department;
import com.example.hospital.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }
    public void saveDepartment(Department department){
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
