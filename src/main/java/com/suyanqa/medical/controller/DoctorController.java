package com.suyanqa.medical.controller;

import com.suyanqa.medical.mod.Doctor;
import com.suyanqa.medical.server.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 15:22
 * @Author ： SuYan
 * @File ：DoctorController.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private DoctorService doctorsService;

    @Autowired
    public DoctorController(DoctorService doctorServices) {
        this.doctorsService = doctorServices;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Doctor>> listAllDoctors() {
        List<Doctor> doctors = doctorsService.findAll();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/get")
    public ResponseEntity<Doctor> getDoctor(@RequestParam Integer doctorId) {
        Optional<Doctor> doctor = doctorsService.findById(doctorId);
        return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<Doctor> addPatient(@RequestBody Doctor doctor) {
        Doctor savedPatient = doctorsService.save(doctor);
        return ResponseEntity.ok(savedPatient);
    }

    @PutMapping("/update")
    public ResponseEntity<Doctor> updatePatient(@RequestBody Doctor doctor) {
        if (doctorsService.existsById(doctor.getId())) {
            Doctor updatedPatient = doctorsService.save(doctor);
            return ResponseEntity.ok(updatedPatient);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePatient(@RequestParam Integer id) {
        System.out.println(id);
        if (doctorsService.existsById(id)) {
            doctorsService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
