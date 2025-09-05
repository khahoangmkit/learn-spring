package com.example.learn_spring.controller;

import com.example.learn_spring.dto.request.AuthenticationRequest;
import com.example.learn_spring.dto.request.IntrospectRequest;
import com.example.learn_spring.dto.response.ApiResponse;
import com.example.learn_spring.dto.response.AuthenticationResponse;
import com.example.learn_spring.dto.response.IntrospectResponse;
import com.example.learn_spring.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse result = authenticationService.authentication(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .code(1000)
                .message("Success!")
                .data(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> login(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        IntrospectResponse result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .code(1000)
                .message("Success!")
                .data(result)
                .build();
    }



}
