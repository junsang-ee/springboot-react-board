package com.springboot.web.controller;

import com.springboot.web.model.dto.request.BoardSaveRequest;
import com.springboot.web.model.entity.BoardEntity;
import com.springboot.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public BoardEntity save(@RequestBody BoardSaveRequest request) {
        return boardService.save(request);
    }
}
