package com.springboot.web.service;

import com.springboot.web.model.dto.request.UserSaveRequest;
import com.springboot.web.model.entity.UserEntity;
import com.springboot.web.model.entity.count.FollowCountEntity;
import com.springboot.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserEntity save(UserSaveRequest request) {
        UserEntity user = getUserEntity(request);
        user.setFollowCount();
        return userRepository.save(user);
    }

    @Override
    public UserEntity get(String userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("not found user")
        );
    }

    public Optional<UserEntity> getByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    private UserEntity getUserEntity(UserSaveRequest request) {
        return UserEntity.builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .email(request.getEmail())
                .role(request.getRole())
                .followCount(new FollowCountEntity())
                .build();
    }

}
