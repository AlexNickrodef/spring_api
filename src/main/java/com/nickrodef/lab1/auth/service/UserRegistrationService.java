package com.nickrodef.lab1.auth.service;

import com.nickrodef.lab1.entity.User;
import com.nickrodef.lab1.repository.UserRepository;
import com.nickrodef.lab1.request.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(RegisterUserRequest registerUserRequest) {
        User newUser = new User();

        newUser.setName(registerUserRequest.getName());
        newUser.setEmail(registerUserRequest.getEmail());

        userRepository.save(newUser);

        return newUser;
    }

}