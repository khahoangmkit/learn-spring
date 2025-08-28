package com.example.learn_spring.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_EXISTS(1001, "User already exists")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

}
