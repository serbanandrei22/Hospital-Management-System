package com.example.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String id;
    private String hospitalId;
    private double capacity;
    private String number;
    private String status;
    private List<String> appointments;


    private int floorNumber;

    public Room() {
        this.appointments = new ArrayList<>();}

    public Room(String id, String hospitalId, double capacity, String number, String status, int floorNumber) {
        this.id = id;
        this.hospitalId = hospitalId;
        this.capacity = capacity;
        this.number = number;
        this.status = status;
        this.floorNumber = floorNumber;
        this.appointments = new ArrayList<>();}

    public String getId() {
        return id;}
    public void setId(String id) {
        this.id = id;}
    public String getHospitalId() {
        return hospitalId;}
    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;}
    public double getCapacity() {
        return capacity;}
    public void setCapacity(double capacity) {
        this.capacity = capacity;}
    public String getNumber() {
        return number;}
    public void setNumber(String number) {
        this.number = number;}
    public String getStatus() {
        return status;}
    public void setStatus(String status) {
        this.status = status;}
    public List<String> getAppointments() {
        return appointments;}
    public void setAppointments(List<String> appointments) {
        this.appointments = appointments;}
    public int getFloorNumber() {
        return floorNumber;}
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;}
}