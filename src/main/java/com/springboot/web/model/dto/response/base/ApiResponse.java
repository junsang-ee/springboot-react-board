package com.springboot.web.model.dto.response.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ApiResponse {
    private final int code;
    private final String message;

}
