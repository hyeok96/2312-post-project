package com.example.PostProject.yooni.controller;

import com.example.PostProject.yooni.controller.dto.Request.SignupRequest;
import com.example.PostProject.yooni.model.User;
import com.example.PostProject.yooni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupRequest signupRequest) {
        User createdUser = userService.signup(signupRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    // 이메일로 사용자 조회 API 엔드포인트 추가
    @GetMapping("/find-by-email")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        return userService.findByEmail(email)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 추가적인 API 엔드포인트 및 메소드 추가
}