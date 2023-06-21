package com.springboot.web.service;

import com.springboot.web.model.dto.request.UserSaveRequest;
import com.springboot.web.model.entity.UserEntity;
import com.springboot.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserEntity save(UserSaveRequest request) {
        return userRepository.save(getUserEntity(request));
    }

    @Override
    public UserEntity get(String userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("not found user")
        );
    }

    private UserEntity getUserEntity(UserSaveRequest request) {
        return UserEntity.builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();
    }
}
