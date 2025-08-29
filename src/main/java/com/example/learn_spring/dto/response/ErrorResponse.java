package com.example.learn_spring.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // nếu ko khai báo thì default là private
public class ErrorResponse {

    String message;

    Object detailError;
}
