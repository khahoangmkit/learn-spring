package com.example.learn_spring.controller;

import com.example.learn_spring.dto.request.AuthenticationRequest;
import com.example.learn_spring.dto.response.ApiResponse;
import com.example.learn_spring.dto.response.AuthenticationResponse;
import com.example.learn_spring.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        boolean result = authenticationService.authentication(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .code(1000)
                .message("Login success!")
                .data(AuthenticationResponse.builder().authentication(result).build())
                .build();
    }

}
