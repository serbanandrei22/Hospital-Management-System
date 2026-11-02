package com.example.hospital.service;
import com.example.hospital.model.Hospital;
import com.example.hospital.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    public HospitalService(HospitalRepository hospitalRepository){
        this.hospitalRepository=hospitalRepository;
    }
    public void saveHospital(Hospital hospital){
        hospitalRepository.save(hospital);
    }
    public Hospital getHospitalById(String id){
        return hospitalRepository.findById(id);
    }

    public List<Hospital> getAllHospital(){
        return hospitalRepository.findAll();
    }
    public void deleteHospital(String id){
        hospitalRepository.delete(id);
    }
}
