package com.example.hospital.repository;

import com.example.hospital.model.Hospital;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository extends InFileRepository<Hospital> {
    public HospitalRepository() {
        super("src/main/resources/data/Hospital.json", Hospital.class);
    }
}
