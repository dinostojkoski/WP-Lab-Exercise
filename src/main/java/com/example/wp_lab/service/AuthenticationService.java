package com.example.wp_lab.service;

import com.example.wp_lab.model.User;

public interface AuthenticationService {
    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname);
}
