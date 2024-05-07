package com.suyanqa.medical.controller;

import com.suyanqa.medical.mod.Medical;
import com.suyanqa.medical.server.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class MedicalController {

    private MedicalService medicalService;

    @Autowired
    public MedicalController(MedicalService medicalService) {
        this.medicalService = medicalService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Medical>> listAllPatients() {
        List<Medical> patients = medicalService.findAll();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/get")
    public ResponseEntity<Medical> getPatient(@RequestParam Integer patientId) {
        Optional<Medical> patient = medicalService.findById(patientId);
        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Medical> addPatient(@RequestBody Medical patient) {
        Medical savedPatient = medicalService.save(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @PutMapping("/update")
    public ResponseEntity<Medical> updatePatient(@RequestBody Medical patient) {
        if (medicalService.existsById(patient.getRecordId())) {
            Medical updatedPatient = medicalService.save(patient);
            return ResponseEntity.ok(updatedPatient);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePatient(@RequestParam Integer patientId) {
        if (medicalService.existsById(patientId)) {
            medicalService.deleteById(patientId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
