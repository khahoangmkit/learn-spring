package com.example.learn_spring.mapper;

import com.example.learn_spring.dto.request.UpdateUserRequest;
import com.example.learn_spring.dto.request.UserCreateRequest;
import com.example.learn_spring.dto.response.UserResponse;
import com.example.learn_spring.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.lang.annotation.Target;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);
    User toUser(UserCreateRequest userRequest);

    @Mapping(target = "id", ignore = true) // ko map id
    void updateUser(@MappingTarget User user, UpdateUserRequest userRequest);
}
