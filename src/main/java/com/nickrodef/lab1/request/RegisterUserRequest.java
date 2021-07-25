package com.nickrodef.lab1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class RegisterUserRequest {

    @NotBlank
    public String email;

    @NotBlank
    public String name;

}
