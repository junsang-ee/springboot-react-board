package com.springboot.web.service;

import com.springboot.web.model.dto.response.FollowSaveResponse;
import com.springboot.web.model.entity.FollowEntity;
import com.springboot.web.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FollowServiceImpl implements FollowService{

    private final UserService userService;

    private final FollowRepository followRepository;

    @Override
    public FollowSaveResponse save(String fromUserId, String toUserId) {
        FollowEntity followEntity = followRepository
                .save(getFollowEntity(fromUserId, toUserId));
        return toFollowResponseDto(followEntity);
    }

    private FollowEntity getFollowEntity(String fromUserId,
                                         String toUserId) {
        FollowEntity result = new FollowEntity();
        result.setFromUser(userService.get(fromUserId));
        result.setToUser(userService.get(toUserId));
        return result;

    }

    private FollowSaveResponse toFollowResponseDto(FollowEntity entity) {
        FollowSaveResponse result = new FollowSaveResponse() ;
        result.setUserName(entity.getFromUser().getUserName());
        return result;
    }

}
