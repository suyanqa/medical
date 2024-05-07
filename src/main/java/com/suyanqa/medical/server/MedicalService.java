package com.suyanqa.medical.server;

import com.suyanqa.medical.mod.Medical;
import com.suyanqa.medical.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalService {

    private MedicalRepository medicalRepository;

    @Autowired
    public MedicalService(MedicalRepository medicalRepository) {
        this.medicalRepository = medicalRepository;
    }

    public List<Medical> findAll() {
        return (List<Medical>) medicalRepository.findAll();
    }

    public Optional<Medical> findById(Integer id) {
        return medicalRepository.findById(id);
    }

    public Medical save(Medical medical) {
        return medicalRepository.save(medical);
    }

    public boolean existsById(Integer id) {
        return medicalRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        medicalRepository.deleteById(id);
    }
}
