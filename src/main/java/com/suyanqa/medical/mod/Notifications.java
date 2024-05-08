package com.suyanqa.medical.mod;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 16:57
 * @Author ： SuYan
 * @File ：Notifications.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */
@Table("notifications")
public class Notifications {
    @Id
    private int id;
    @Column("type")
    private String type;
    @Column("doctor_id")
    private int doctor_id;
    @Column("patient_id")
    private int patient_id;
    @Column("content")
    private String content;
    @Column("created_at")
    private LocalDateTime created_at;
    @Column("status")
    private String status;

    public Notifications() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
