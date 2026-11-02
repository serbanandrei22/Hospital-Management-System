package com.example.hospital.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Appointment {
    private String id;
    private String departmentId;
    private String patientId;
    private LocalDate admissionDate;
    private String status;
    private List<String> medicalStaff;

    public Appointment() {
        this.medicalStaff = new ArrayList<>();
    }

    public Appointment(String id, String departmentId, String patientId, LocalDate admissionDate, String status) {
        this.id = id;
        this.departmentId = departmentId;
        this.patientId = patientId;
        this.admissionDate = admissionDate;
        this.status = status;
        this.medicalStaff = new ArrayList<>();
    }


}