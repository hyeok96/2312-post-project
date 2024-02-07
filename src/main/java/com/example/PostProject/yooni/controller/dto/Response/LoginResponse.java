package com.example.PostProject.yooni.controller.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String message;

    public LoginResponse(String message) {
        this.message = message;
    }
}
