package com.example.learn_spring.dto.response;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String address;
}
