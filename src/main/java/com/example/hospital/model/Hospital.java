package com.example.hospital.model;
import java.util.ArrayList;
import java.util.List;
public class Hospital {
    private String id;
    private String name;
    private String city;
    private String emergencyHotline;//adaugata in plus
    private List<String> departments;
    private List<String> rooms;

    public Hospital() {
        this.departments = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public Hospital(String id, String name, String city, String emergencyHotline) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.emergencyHotline = emergencyHotline;
        this.departments = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmergencyHotline() {
        return emergencyHotline;
    }

    public void setEmergencyHotline(String emergencyHotline) {
        this.emergencyHotline = emergencyHotline;
    }
    public List<String> getDepartments(){return departments;}
    public void setDepartments(List<String> departments){this.departments=departments;}

    public List<String> getRooms(){return rooms;}
    public void setRooms(List<String> rooms){this.rooms=rooms;}
}

