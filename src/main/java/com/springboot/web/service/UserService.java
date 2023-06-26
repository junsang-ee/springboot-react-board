package com.springboot.web.service;

import com.springboot.web.model.dto.request.UserSaveRequest;
import com.springboot.web.model.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    UserEntity get(String userId);

    UserEntity save(UserSaveRequest request);

    Optional<UserEntity> getByUserName(String userName);
}
