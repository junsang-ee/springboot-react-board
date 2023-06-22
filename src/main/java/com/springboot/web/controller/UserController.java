package com.springboot.web.controller;

import com.springboot.web.model.dto.request.UserSaveRequest;
import com.springboot.web.model.entity.UserEntity;
import com.springboot.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserEntity save(@RequestBody UserSaveRequest request) {
        return userService.save(request);
    }

    @GetMapping("user")
    public void user() {}

    @GetMapping("admin")
    public void admin() {}
}
