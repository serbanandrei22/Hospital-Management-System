package com.example.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//commit 1
@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Die Anwendung funktioniert!";
    }
}
//package com.example.hospital.controller;
//
//import com.example.hospital.model.Hospital;
//import com.example.hospital.model.Patient;
//import com.example.hospital.service.HospitalService;
//import com.example.hospital.service.PatientService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class HelloController {
//
//    private final HospitalService hospitalService;
//    private final PatientService patientService;
//
//    public HelloController(HospitalService hospitalService, PatientService patientService) {
//        this.hospitalService = hospitalService;
//        this.patientService = patientService;
//    }
//
//    @GetMapping("/hello")
//    @ResponseBody
//    public String sayHello() {
//        return "Die Anwendung funktioniert!";
//    }
//
//    @GetMapping("/test")
//    @ResponseBody
//    public String testArchitecture() {
//        Hospital hospital = new Hospital("H1", "Spital Clinic", "Cluj", "+40 264 000 000");
//        hospitalService.saveHospital(hospital);
//
//        Patient patient = new Patient("P1", "Ion Popescu", "ion@test.com", "0712345678");
//        patientService.savePatient(patient);
//
//        return "OK! Hospital: " + hospitalService.getHospitalById("H1").getName()
//                + " | Patient: " + patientService.getPatientById("P1").getName();
//    }
//}