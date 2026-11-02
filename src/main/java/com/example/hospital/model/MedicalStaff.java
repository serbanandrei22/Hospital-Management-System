package com.example.hospital.model;
import java.util.ArrayList;
import java.util.List;

public abstract class MedicalStaff {
    private String id;
    private String name;
    private List<String> appointments;
    private String departmentId;
    public MedicalStaff(){
        this.appointments=new ArrayList<>();
    }
    public MedicalStaff(String id,String name,String departmentID){
        this.id=id;
        this.name=name;
        this.departmentId=departmentID;
        this.appointments=new ArrayList<>();
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public List<String> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<String> appointments) {
        this.appointments = appointments;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
