package com.example.hospital.service;

import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }
    public void saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }
    public Doctor getDoctorById(String id){
        return doctorRepository.findById(id);
    }
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    public void deleteDoctor(String id){
        doctorRepository.delete(id);
    }
}
