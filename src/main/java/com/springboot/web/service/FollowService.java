package com.springboot.web.service;

import com.springboot.web.model.dto.response.FollowSaveResponse;

public interface FollowService {
    FollowSaveResponse save(String fromUser, String toUser);
}
