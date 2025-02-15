package com.artbylakshmi.controller;

import com.artbylakshmi.entity.User;
import com.artbylakshmi.model.AuthRequest;
import com.artbylakshmi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Auth {

    @Autowired
    private UserService userService;

    // Authentication method
    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest) {
        // Check if the provided credentials match the hardcoded values
        Optional<User> user = userService.authenticate(authRequest.getUsername(), authRequest.getPassword());
        if (user.isPresent() && user.get().isAccountEnabled()
                && user.get().getUsername().equals(authRequest.getUsername())
        && user.get().getPassword().equals(authRequest.getPassword())) {
            return "Authentication successful - ADMIN";
        } else {
            return "Authentication failed: Invalid username or password";
        }
    }


}
