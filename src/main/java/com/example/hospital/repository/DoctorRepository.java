package com.example.hospital.repository;

import com.example.hospital.model.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepository extends InFileRepository<Doctor> {
    public DoctorRepository(){
        super("src/main/resources/data/Doctor.json",Doctor.class);
    }
}

