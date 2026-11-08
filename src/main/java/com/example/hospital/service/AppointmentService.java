package com.example.hospital.service;

import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.model.Appointment;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Patient;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
    }

    public Appointment getAppointmentById(String id){return appointmentRepository.findById(id);}
    public void saveAppointment(Appointment appointment) {
        this.appointmentRepository.save(appointment);
        Patient patient = this.patientService.getPatientById(appointment.getPatientId());
        if (patient != null) {
            patient.getAppointments().add(appointment.getId());
            this.patientService.savePatient(patient);
        }
    }
    public void deleteAppointment(String id){
        appointmentRepository.delete(id);
    }
    public List<Appointment> getAllAppointments(){return appointmentRepository.findAll();}
    public List<Appointment> getAppointmentByPatientID(String id){
        return appointmentRepository.findByPatientId(id);
    }
}
