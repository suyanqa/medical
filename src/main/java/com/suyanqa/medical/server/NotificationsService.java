package com.suyanqa.medical.server;

import com.suyanqa.medical.mod.Notifications;
import com.suyanqa.medical.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 17:01
 * @Author ： SuYan
 * @File ：NotificationsService.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */
@Service
public class NotificationsService {
    private NotificationsRepository notificationsRepository;

    @Autowired
    public NotificationsService(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }

    public List<Notifications> findAll() {
        return (List<Notifications>) notificationsRepository.findAll();
    }

    public Optional<Notifications> findById(Integer id) {
        return notificationsRepository.findById(id);
    }

    public Notifications save(Notifications notifications) {
        return notificationsRepository.save(notifications);
    }

    public void deleteById(Integer id) {notificationsRepository.deleteById(id);}

    public Boolean existsById(Integer id) { return notificationsRepository.existsById(id);}
}
