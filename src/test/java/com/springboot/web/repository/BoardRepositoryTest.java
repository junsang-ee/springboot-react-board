package com.springboot.web.repository;

import com.springboot.web.constants.DisclosureStatusType;
import com.springboot.web.model.entity.BoardEntity;
import com.springboot.web.model.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 보드가_저장된다() {
        UserEntity user = userRepository.save(UserEntity.builder()
                .userName("name")
                .email("email")
                .password("password")
                .build());

        String name = "test";
        DisclosureStatusType disclosureStatusType = DisclosureStatusType.PUBLIC;

        BoardEntity boardEntity = BoardEntity.builder()
                .name(name)
                .disclosureStatusType(disclosureStatusType)
                .user(user)
                .build();

        log.info("board -> {}", boardEntity);

        BoardEntity board = boardRepository.save(boardEntity);

        Assertions.assertThat(board.getName()).isEqualTo(name);
        Assertions.assertThat(board.getDisclosureStatusType()).isEqualTo(disclosureStatusType);
        Assertions.assertThat(board.getCreatedBy().getUserName()).isEqualTo(user.getUserName());

    }

}