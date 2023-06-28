package com.springboot.web.controller;

import com.springboot.web.model.dto.request.UserSaveRequest;
import com.springboot.web.model.dto.response.FollowSaveResponse;
import com.springboot.web.model.entity.UserEntity;
import com.springboot.web.service.FollowService;
import com.springboot.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {
    private final UserService userService;

    private final FollowService followService;

    @PostMapping
    public UserEntity save(@RequestBody UserSaveRequest request) {
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

    @PostMapping("/{userId}/follow")
    public FollowSaveResponse follow(@PathVariable String userId) {
        return followService.save("{login_user_id}", userId);
    }
}
