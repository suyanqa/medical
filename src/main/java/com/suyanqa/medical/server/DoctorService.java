package com.suyanqa.medical.server;

import com.suyanqa.medical.mod.Doctor;
import com.suyanqa.medical.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 15:24
 * @Author ： SuYan
 * @File ：DoctorServices.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */
@Service
public class DoctorService {
    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRespository) {
        this.doctorRepository = doctorRespository;
    }

    public List<Doctor> findAll() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    public Optional<Doctor> findById(Integer id) {
        return doctorRepository.findById(id);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public boolean existsById(Integer id) {
        return doctorRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        doctorRepository.deleteById(id);
    }
}
