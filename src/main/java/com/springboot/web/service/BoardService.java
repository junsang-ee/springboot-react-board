package com.springboot.web.service;

import com.springboot.web.model.dto.request.BoardSaveRequest;
import com.springboot.web.model.entity.BoardEntity;

public interface BoardService {
    BoardEntity save(BoardSaveRequest request);
}
