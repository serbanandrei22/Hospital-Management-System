package com.example.hospital.repository;

import com.example.hospital.model.Patient;
import org.springframework.stereotype.Repository;


@Repository
public class PatientRepository extends InFileRepository<Patient> {

    public PatientRepository() {
        super("src/main/resources/data/Patient.json", Patient.class);
    }
}