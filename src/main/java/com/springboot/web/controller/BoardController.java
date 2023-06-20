package com.springboot.web.controller;

import com.springboot.web.model.entity.BoardEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/board")
@RestController
public class BoardController {

    @PostMapping
    public BoardEntity save() {
        return new BoardEntity();
    }
}
