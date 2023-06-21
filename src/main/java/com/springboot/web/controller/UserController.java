package com.springboot.web.controller;

import com.springboot.web.model.dto.request.UserSaveRequest;
import com.springboot.web.model.entity.UserEntity;
import com.springboot.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserEntity save(@RequestBody UserSaveRequest request) {
        return userService.save(request);
    }
}
