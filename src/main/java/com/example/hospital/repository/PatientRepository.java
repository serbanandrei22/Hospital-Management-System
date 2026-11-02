package com.example.hospital.repository;

import com.example.hospital.model.Patient;
import org.springframework.stereotype.Repository;


@Repository
public class PatientRepository extends InMemoryRepository<Patient> {
}