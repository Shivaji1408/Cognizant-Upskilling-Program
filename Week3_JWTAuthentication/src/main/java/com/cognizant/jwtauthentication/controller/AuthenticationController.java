package com.cognizant.jwtauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwtauthentication.model.AuthenticationResponse;
import com.cognizant.jwtauthentication.util.JwtUtil;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(Authentication authentication) {

        String token = jwtUtil.generateToken(authentication.getName());

        return new AuthenticationResponse(token);
    }

}