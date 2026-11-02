package com.example.hospital.repository;

import com.example.hospital.model.Hospital;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository extends InMemoryRepository<Hospital> {
}
