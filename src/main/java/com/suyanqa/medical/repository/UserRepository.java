package com.suyanqa.medical.repository;

import com.suyanqa.medical.mod.User;
import org.springframework.data.repository.CrudRepository;

/**
 * # -*- coding: utf-8 -*-
 *
 * @Time ： 2024-05-07 19:18
 * @Author ： SuYan
 * @File ：UserRepository.java
 * @email: suyan1254088@gmail.com
 * @IDE ：IntelliJ IDEA 2021.2.2
 * @Motto ：ABC(Always Be Coding)
 */
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmail(String email);

    boolean existsByEmail(String email);
}
