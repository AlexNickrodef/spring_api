package com.nickrodef.lab1.jwt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class JwtRequest {

    @NotBlank
    public String username;

    @NotBlank
    public String password;

}
