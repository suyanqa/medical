package com.suyanqa.medical.server;

import com.suyanqa.medical.mod.Medicine;
import com.suyanqa.medical.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 15:59
 * @Author ： SuYan
 * @File ：MedicinesServices.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */
@Service
public class MedicinesService {
    private MedicinesRepository medicinesRepository;

    @Autowired
    public MedicinesService(MedicinesRepository medicinesRepository) {
        this.medicinesRepository = medicinesRepository;
    }

    public List<Medicine> findAll() {
        return (List<Medicine>) medicinesRepository.findAll(); // 向下转型
    }

    public Optional<Medicine> findById(int id) {
        return medicinesRepository.findById(id);
    }

    public Medicine save(Medicine medicine) {
        return medicinesRepository.save(medicine);
    }

    public boolean existsById(Integer id) {
        return medicinesRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        medicinesRepository.deleteById(id);
    }
}
