package com.nickrodef.lab1.auth.controller;

import com.nickrodef.lab1.entity.User;
import com.nickrodef.lab1.jwt.request.JwtRequest;
import com.nickrodef.lab1.request.RegisterUserRequest;
import com.nickrodef.lab1.auth.service.UserRegistrationService;
import com.nickrodef.lab1.jwt.response.JwtResponse;
import com.nickrodef.lab1.response.ApiResponse;
import com.nickrodef.lab1.service.UserService;
import com.nickrodef.lab1.jwt.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse register(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        try {
            User newUser = userRegistrationService.registerUser(registerUserRequest);

            return ApiResponse.success(newUser);
        } catch (Exception e) {
            return ApiResponse.fail("Can't register this credentials.");
        }
    }

    @PostMapping("/auth")
    public JwtResponse authenticate(@RequestBody @Valid JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }
}
