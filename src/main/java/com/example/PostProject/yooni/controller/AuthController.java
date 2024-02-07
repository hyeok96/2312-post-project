package com.example.PostProject.yooni.controller;

import com.example.PostProject.yooni.controller.dto.Request.LoginRequest;
import com.example.PostProject.yooni.controller.dto.Response.LoginResponse;
import com.example.PostProject.yooni.controller.dto.Request.LogoutRequest;
import com.example.PostProject.yooni.controller.dto.Response.LogoutResponse;
import com.example.PostProject.yooni.controller.dto.Request.SignupRequest;
import com.example.PostProject.yooni.controller.dto.Response.SignupResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request) {
        // 여기에서 회원가입 로직을 처리, 성공적으로 가입되면 응답을 생성
        SignupResponse response = new SignupResponse("회원가입이 완료되었습니다.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        // 여기에서 로그인 로직을 처리, 성공적으로 로그인되면 응답을 생성
        LoginResponse response = new LoginResponse("로그인이 성공적으로 완료되었습니다.");

        // 여기에 토큰 생성 및 설정 코드를 추가 필요
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logout(@RequestBody LogoutRequest request) {
        // 여기에서 로그아웃 로직을 처리, 성공적으로 로그아웃되면 응답을 생성
        LogoutResponse response = new LogoutResponse("로그아웃되었습니다.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
