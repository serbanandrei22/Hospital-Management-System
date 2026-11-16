package com.example.hospital.service;

import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.model.Appointment;
import com.example.hospital.model.Department;
import org.springframework.stereotype.Service;
import com.example.hospital.model.Patient;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final DepartmentService departmentService;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientService patientService,DepartmentService departmentService) {
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
        this.departmentService=departmentService;
    }

    public Appointment getAppointmentById(String id){return appointmentRepository.findById(id);}
    public void saveAppointment(Appointment appointment) {
        if (appointment.getPatientId() != null && !appointment.getPatientId().isEmpty()) {
            Patient p = patientService.getPatientById(appointment.getPatientId());
            if (p == null) {
                throw new IllegalArgumentException("Eroare: Pacientul cu ID-ul " + appointment.getPatientId() + " nu exista!");
            }
        }

        if (appointment.getDepartmentId() != null && !appointment.getDepartmentId().isEmpty()) {
            Department d = departmentService.getDepartmentById(appointment.getDepartmentId());
            if (d == null) {
                throw new IllegalArgumentException("Eroare: Departamentul cu ID-ul " + appointment.getDepartmentId() + " nu exista!");
            }
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
