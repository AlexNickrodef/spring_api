package com.nickrodef.lab1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to lab1 project.";
    }

}
