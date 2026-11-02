package com.example.hospital.service;

import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }

    public Appointment getAppointmentById(String id){return appointmentRepository.findById(id);}
    public void saveAppointment(Appointment appointment){
        appointmentRepository.save(appointment);
    }
    public void deleteAppointment(String id){
        appointmentRepository.delete(id);
    }
    public List<Appointment> getAllAppointments(AppointmentRepository appointmentRepository){return appointmentRepository.findAll();}
    public List<Appointment> getAppointmentByPatientID(String id){
        return appointmentRepository.findByPatientId(id);
    }
}
