package com.example.DV.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    // getter, setter
    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
