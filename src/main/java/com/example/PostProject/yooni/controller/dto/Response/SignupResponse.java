package com.example.PostProject.yooni.controller.dto.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignupResponse {
    private String message;

    public SignupResponse(String message) {
        this.message = message;
    }
}
