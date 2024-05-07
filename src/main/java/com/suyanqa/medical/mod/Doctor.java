package com.suyanqa.medical.mod;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 15:16
 * @Author ： SuYan
 * @File ：Doctor.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */

@Table("doctors")
public class Doctor {
    @Id
    private int id;
    private String name;
    private int age;
    private String gender;
    private String contact;
    private String address;
    private String certification;
    private String specialty;
    private String clinicalExperience;
    private String schedule;
    private String leaveSchedule;
    private String communicationRecords;
    private String medicalRecords;

    public Doctor() {
    }

    public Doctor(int id, String name, int age, String gender, String contact,
                  String address, String certification, String specialty,
                  String clinicalExperience, String schedule, String leaveSchedule, String communicationRecords, String medicalRecords) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
        this.certification = certification;
        this.specialty = specialty;
        this.clinicalExperience = clinicalExperience;
        this.schedule = schedule;
        this.leaveSchedule = leaveSchedule;
        this.communicationRecords = communicationRecords;
        this.medicalRecords = medicalRecords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getClinicalExperience() {
        return clinicalExperience;
    }

    public void setClinicalExperience(String clinicalExperience) {
        this.clinicalExperience = clinicalExperience;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getLeaveSchedule() {
        return leaveSchedule;
    }

    public void setLeaveSchedule(String leaveSchedule) {
        this.leaveSchedule = leaveSchedule;
    }

    public String getCommunicationRecords() {
        return communicationRecords;
    }

    public void setCommunicationRecords(String communicationRecords) {
        this.communicationRecords = communicationRecords;
    }

    public String getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(String medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
