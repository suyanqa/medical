package com.suyanqa.medical.controller;

import com.suyanqa.medical.mod.Medicine;
import com.suyanqa.medical.server.MedicalService;
import com.suyanqa.medical.server.MedicinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 15:46
 * @Author ： SuYan
 * @File ：MedicinesController.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */
@RestController
@RequestMapping("/medic")
public class MedicinesController {
    private final MedicalService medicalService;
    private MedicinesService medicinesServices;

    @Autowired
    public MedicinesController(MedicinesService medicinesServices, MedicalService medicalService) {
        this.medicinesServices = medicinesServices;
        this.medicalService = medicalService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Medicine>> listAllMedicines() {
        List<Medicine> all = medicinesServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/get")
    public ResponseEntity<Medicine> getMedicineById(@RequestParam Integer MedicineId) {
        Optional<Medicine> getMedicine = medicinesServices.findById(MedicineId);
        return getMedicine.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
        Medicine saveMedicine = medicinesServices.save(medicine);
        return ResponseEntity.ok(saveMedicine);
    }

    @PutMapping("/update")
    public ResponseEntity<Medicine> updateMedicine(@RequestBody Medicine medicine) {
        if (medicinesServices.existsById(medicine.getId())) {
            Medicine saveMedicine = medicinesServices.save(medicine);
            return ResponseEntity.ok(saveMedicine);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Medicine> deleteMedicine(@RequestParam Integer id) {
        if (medicinesServices.existsById(id)) {
            medicinesServices.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
