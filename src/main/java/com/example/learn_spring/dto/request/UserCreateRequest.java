package com.example.learn_spring.dto.request;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private String username;
    private String password;
}
