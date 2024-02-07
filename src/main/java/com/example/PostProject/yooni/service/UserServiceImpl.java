package com.example.PostProject.yooni.service;

import com.example.PostProject.yooni.controller.dto.Request.LoginRequest;
import com.example.PostProject.yooni.controller.dto.Request.SignupRequest;
import com.example.PostProject.yooni.controller.dto.Response.LoginResponse;
import com.example.PostProject.yooni.model.User;
import com.example.PostProject.yooni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signup(SignupRequest signupRequest) {
        return null;
    }

    @Override
    public User signup(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }
}
