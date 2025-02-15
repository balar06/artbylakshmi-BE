package com.artbylakshmi.service;

import com.artbylakshmi.entity.User;
import com.artbylakshmi.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> authenticate(String username, String password) {
        System.out.println("username "+ username);
        System.out.println("password "+ password);
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);

        return user;
    }

}
