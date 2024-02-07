package com.example.PostProject.yooni.controller.dto.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {
    private String email;
    private String password;

    public SignupRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
