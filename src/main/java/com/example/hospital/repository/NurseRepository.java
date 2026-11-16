package com.example.hospital.repository;

import com.example.hospital.model.Nurse;
import org.springframework.stereotype.Repository;
@Repository
public class NurseRepository extends InFileRepository<Nurse>{

    public NurseRepository() {
        super("src/main/resources/data/Nurse.json", Nurse.class);
    }
}
