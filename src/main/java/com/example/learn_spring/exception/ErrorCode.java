package com.example.learn_spring.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    ERROR_NOT_REGISTERED(1003, "ERROR_NOT_REGISTERED"),
    PASSWORD_TOO_SHORT(1002, "PASSWORD_TOO_SHORT"),
    USER_EXISTS(1001, "USER_EXISTS"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

}
