package com.example.learn_spring.exception;

import com.example.learn_spring.dto.response.ApiResponse;
import com.example.learn_spring.dto.response.ErrorResponse;
import com.example.learn_spring.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Xử lý exception tập chung cho cả dự án
@ControllerAdvice
public class GlobalExceptionHandler {

    protected ErrorResponse logErrorAndBuildResponse(String messageError, String msgCode, Object... params) {
        // Có thể thêm messageCode để phục vụ cho việc multi language get message từ msgCode vaf params
        // String msg = Translator.toLocale(msgCode, params);
        return ErrorResponse.builder().message(msgCode).detailError(messageError).build();
    }

    //Định nghĩa exception RuntimeException
    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.badRequest().body(logErrorAndBuildResponse(e.getMessage(), "msg_error_runtime"));
    }

    //Định nghĩa exception APP_Exception
    @ExceptionHandler(AppException.class)
    ResponseEntity<ApiResponse> handleAppException(AppException e) {

        return ResponseEntity.badRequest().body(ApiResponse.<UserResponse>builder()
                .code(e.getErrorCode().getCode())
                .message(e.getMessage())
                .build()
        );
    }

    //Định nghĩa exception MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(logErrorAndBuildResponse(e.getFieldError().getDefaultMessage(), "msg_error_method_argument_not_valid"));
    }
}
