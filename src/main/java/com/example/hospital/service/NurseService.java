package com.example.hospital.service;

import com.example.hospital.model.Nurse;
import com.example.hospital.repository.NurseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {
    private final NurseRepository nurseRepository;

    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public void saveNurse(Nurse nurse) {
        nurseRepository.save(nurse);
    }

    public Nurse getNurseById(String id) {
        return nurseRepository.findById(id);
    }

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public void deleteNurse(String id) {
        nurseRepository.delete(id);
    }
}