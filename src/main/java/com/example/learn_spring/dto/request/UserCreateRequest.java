package com.example.learn_spring.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {
    private String fullName;
    private String phone;
    private String email;
    private String address;

    @NotEmpty(message = "Username is required")
    private String username;
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
}
