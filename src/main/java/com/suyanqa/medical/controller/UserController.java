package com.suyanqa.medical.controller;

import com.suyanqa.medical.mod.ForgotPasswordRequest;
import com.suyanqa.medical.mod.User;
import com.suyanqa.medical.server.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 19:10
 * @Author ： SuYan
 * @File ：UserController.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    // 注册功能
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        System.out.println("controller层接收到的user: "+user.toString());
        if (userServices.register(user)) {
            return "注册成功";
        } else {
            return "注册失败,用户已存在";
        }
    }

    // 登录功能
    @PostMapping("/login")
    public String login(@RequestBody User user) {
//        System.out.println(user.toString());
        if (userServices.login(user.getEmail(), user.getPassword())) {
//            System.out.println(user.getEmail() + "\n" + user.getPassword());
            return "登录成功";
        } else {
            return "登录失败无效的电子邮件或密码";
        }
    }

    // 忘记密码功能
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        System.out.println(forgotPasswordRequest.getEmail()+forgotPasswordRequest.getNewPassword());
        if (userServices.resetPassword(forgotPasswordRequest.getEmail(), forgotPasswordRequest.getNewPassword())) {
            return "密码更改成功";
        } else {
            return "密码重置失败,用户未找到";
        }
    }
}
