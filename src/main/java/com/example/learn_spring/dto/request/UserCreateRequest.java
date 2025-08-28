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

    @NotEmpty(message = "USERNAME_EXISTS")
    private String username;
    @Size(min = 6, message = "PASSWORD_TOO_SHORT")
    private String password;
}
