package com.example.learn_spring.mapper;

import com.example.learn_spring.dto.request.UserCreateRequest;
import com.example.learn_spring.dto.response.UserResponse;
import com.example.learn_spring.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);
    User toUser(UserCreateRequest userRequest);
}
