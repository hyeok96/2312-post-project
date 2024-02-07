package com.example.PostProject.yooni.controller.dto.Response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutResponse {
    private String message;

    public LogoutResponse(String message) {
        this.message = message;
    }
}
