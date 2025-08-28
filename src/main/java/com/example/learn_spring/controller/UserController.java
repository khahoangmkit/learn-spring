package com.example.learn_spring.controller;

import com.example.learn_spring.dto.request.UserCreateRequest;
import com.example.learn_spring.dto.response.ApiResponse;
import com.example.learn_spring.dto.response.UserResponse;
import com.example.learn_spring.entity.User;
import com.example.learn_spring.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse user = userService.findUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreateRequest user) {
        UserResponse savedUser = userService.createUser(user);
        return ApiResponse.<UserResponse>builder()
                .code(1000)
                .message("Create user success!")
                .data(savedUser).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        try {
            UserResponse updatedUser = userService.updateUser(id, userDetails);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
