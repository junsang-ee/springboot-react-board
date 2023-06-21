package com.springboot.web.service;

import com.springboot.web.model.dto.request.UserSaveRequest;
import com.springboot.web.model.entity.UserEntity;

public interface UserService {
    UserEntity get(String userId);

    UserEntity save(UserSaveRequest request);
}
