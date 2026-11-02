package com.example.hospital.repository;

import com.example.hospital.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentRepository extends InMemoryRepository<Appointment>{
    public List<Appointment> findByPatientId(String patientId){
        List<Appointment> result = new ArrayList<>();
        for(Appointment appointment: this.objects){
            if(appointment.getPatientId() != null && appointment.getPatientId().equals(patientId)){
                result.add(appointment);
            }
        }
        return result;
    }
}
