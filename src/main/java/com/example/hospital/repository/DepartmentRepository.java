package com.example.hospital.repository;

import com.example.hospital.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository extends InFileRepository<Department> {
    public DepartmentRepository(){
        super("src/main/resources/data/Department.json",Department.class);
    }
}
