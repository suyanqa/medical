package com.suyanqa.medical.mod;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-08 20:21
 * @Author ： SuYan
 * @File ：ForgotPassWordRequest.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */
public class ForgotPasswordRequest {
    private String email;
    private String newPassword;

    // 构造方法、getter和setter
    public ForgotPasswordRequest() {}

    public ForgotPasswordRequest(String email, String newPassword) {
        this.email = email;
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
