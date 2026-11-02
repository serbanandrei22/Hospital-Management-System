package com.example.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String id;
    private String name;
    private List<String> appointments;

    private String email;
    private String phoneNumber;

    public Patient() {
        this.appointments = new ArrayList<>();
    }

    public Patient(String id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.appointments = new ArrayList<>();
    }


}