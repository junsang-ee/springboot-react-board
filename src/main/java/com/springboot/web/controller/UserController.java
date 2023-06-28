package com.springboot.web.controller;

import com.springboot.web.model.dto.request.UserSaveRequest;
import com.springboot.web.model.entity.UserEntity;
import com.springboot.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserEntity save(@RequestBody UserSaveRequest request) {
        log.info("request -> {}", request);
        return userService.save(request);
    }

    @GetMapping("/{userId}")
    public UserEntity get(@PathVariable String userId) {
        return userService.get(userId);
    }

    @GetMapping("user")
    public void user() {}

    @GetMapping("admin")
    public void admin() {}
}
