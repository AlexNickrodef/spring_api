package com.nickrodef.lab1.controller;

import com.nickrodef.lab1.entity.User;
import com.nickrodef.lab1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User> usersList() {
        return userRepository.findAll();
    }

}
