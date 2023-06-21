package com.springboot.web.service;

import com.springboot.web.model.dto.request.BoardSaveRequest;
import com.springboot.web.model.entity.BoardEntity;
import com.springboot.web.model.entity.UserEntity;
import com.springboot.web.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    private final UserService userService;

    @Override
    @Transactional
    public BoardEntity save(BoardSaveRequest request) {
        return boardRepository.save(getBoardEntity(request));
    }

    private BoardEntity getBoardEntity(BoardSaveRequest request) {
        return BoardEntity.builder()
                .name(request.getName())
                .disclosureStatusType(request.getDisclosureStatusType())
                .user(userService.get("{local_user_id}"))
                .build();
    }


}
