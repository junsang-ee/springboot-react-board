package com.springboot.web.service;

import com.springboot.web.model.dto.request.ReplySaveRequest;
import com.springboot.web.model.dto.response.ReplySaveResponse;
import com.springboot.web.model.entity.PostEntity;
import com.springboot.web.model.entity.ReplyEntity;
import com.springboot.web.model.entity.UserEntity;

public interface ReplyService {
     ReplySaveResponse save(String postId, ReplySaveRequest request);
}
