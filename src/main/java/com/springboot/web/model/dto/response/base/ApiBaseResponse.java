package com.springboot.web.model.dto.response.base;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ApiBaseResponse<T> extends ApiResponse {
    private final T data;

    @Builder
    public ApiBaseResponse(int code, String message, T data) {
        super(code, message);
        this.data = data;
    }

}
