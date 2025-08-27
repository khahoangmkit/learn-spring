package com.example.learn_spring.service;

import com.example.learn_spring.dto.request.UserCreateRequest;
import com.example.learn_spring.dto.response.UserResponse;
import com.example.learn_spring.entity.User;
import com.example.learn_spring.mapper.UserMapper;
import com.example.learn_spring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(userMapper::toUserResponse).collect(Collectors.toList());
    }

    public UserResponse findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found with id: " + id));

        return userMapper.toUserResponse(user);
    }

    public User saveUser(UserCreateRequest user) {
        User newUser = userMapper.toUser(user);
        return userRepository.save(newUser);
    }

    public UserResponse updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
        user.setFullName(userDetails.getFullName());
        user.setPhone(userDetails.getPhone());
        user.setEmail(userDetails.getEmail());
        user.setAddress(userDetails.getAddress());

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(user);
    }
}
