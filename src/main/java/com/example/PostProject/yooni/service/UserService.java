package com.example.PostProject.yooni.service;

import com.example.PostProject.yooni.controller.dto.Request.SignupRequest;
import com.example.PostProject.yooni.controller.dto.Request.LoginRequest;
import com.example.PostProject.yooni.controller.dto.Request.LogoutRequest;
import com.example.PostProject.yooni.controller.dto.Response.LoginResponse;
import com.example.PostProject.yooni.model.User;

import java.util.Optional;

public interface UserService {

    User signup(SignupRequest signupRequest);

    User signup(User user);

    Optional<User> findByEmail(String email);

    LoginResponse login(LoginRequest loginRequest);

    // 추가적인 메소드들을 필요에 따라 작성
}