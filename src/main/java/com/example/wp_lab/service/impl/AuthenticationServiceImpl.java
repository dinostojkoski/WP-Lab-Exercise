package com.example.wp_lab.service.impl;

import com.example.wp_lab.model.User;
import com.example.wp_lab.repository.jpa.UserRepository;
import com.example.wp_lab.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        User user = new User(username, repeatPassword, name, surname);
        return userRepository.save(user);
    }
}
