package com.example.hospital.repository;

import com.example.hospital.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentRepository {
    private final List<Appointment> storage = new ArrayList<>();

    public Appointment save(Appointment appointment) {
        delete(appointment.getId());
        storage.add(appointment);
        return appointment;
    }

    public Appointment findById(String id) {
        for (Appointment appointment : storage) {
            if (appointment.getId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }

    public List<Appointment> findAll() {
        return new ArrayList<>(storage);
    }

    public void delete(String id) {
        storage.removeIf(appointment -> appointment.getId().equals(id));
    }
}