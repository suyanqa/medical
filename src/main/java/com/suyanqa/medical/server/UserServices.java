package com.suyanqa.medical.server;

import com.suyanqa.medical.mod.User;
import com.suyanqa.medical.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 19:19
 * @Author ： SuYan
 * @File ：UserServices.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */
@Service
public class UserServices {

    private UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(User user) {
        System.out.println("service层接收到的user: "+user.toString());
        // 检查邮箱是否已经存在（修正这里）
        if (userRepository.existsByEmail(user.getEmail())) {
            return false; // 用户已存在，注册失败
        }
        // 进行用户注册
        userRepository.save(user);
        return true; // 注册成功
    }


    public boolean login(String email, String password) {
        // 根据邮箱查找用户
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true; // 登录成功
        }
        return false; // 登录失败
    }


    public boolean resetPassword(String email, String newPassword) {
        // 根据邮箱查找用户
        User user = userRepository.findByEmail(email);
        if (user != null) {
            // 更新密码
            user.setPassword(newPassword);
            userRepository.save(user);
            return true; // 密码重置成功
        }
        return false; // 用户不存在，密码重置失败
    }
}
