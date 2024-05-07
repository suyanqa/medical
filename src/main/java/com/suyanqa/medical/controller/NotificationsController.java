package com.suyanqa.medical.controller;

import com.suyanqa.medical.mod.Notifications;
import com.suyanqa.medical.server.NotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 16:54
 * @Author ： SuYan
 * @File ：NotificationsController.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */
@RestController
@RequestMapping("/notifs")
public class NotificationsController {

    private NotificationsService notificationsService;

    @Autowired
    public NotificationsController(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Notifications>> getNotifications() {
        List<Notifications> allNotifications = notificationsService.findAll();
        return ResponseEntity.ok(allNotifications);
    }

    @GetMapping("/get")
    public ResponseEntity<Notifications> getNotificationById(@RequestParam Integer id) {
        Optional<Notifications> byId = notificationsService.findById(id);
        return byId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Notifications> addNotification(@RequestBody Notifications notifications) {
        Notifications save = notificationsService.save(notifications);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/update")
    public ResponseEntity<Notifications> updateNotification(@RequestBody Notifications notifications) {
        if (notificationsService.existsById(notifications.getId())) {
            notificationsService.save(notifications);
            return ResponseEntity.ok(notifications);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteNotification(@RequestParam Integer id) {
        if (notificationsService.existsById(id)) {
            notificationsService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
