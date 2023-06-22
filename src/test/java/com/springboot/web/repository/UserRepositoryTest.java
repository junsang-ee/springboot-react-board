package com.springboot.web.repository;

import com.springboot.web.constants.Role;
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
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void 유저가_저장된다() {
        log.info("user Save");
        String name = "user";
        String email = "123@123.123";
        String password = "password";
        Role role = Role.USER;

        UserEntity user = userRepository.save(UserEntity.builder()
                .email(email)
                .userName(name)
                .password(password)
                .role(role)
                .build());

        Assertions.assertThat(user.getUserName()).isEqualTo(name);
        Assertions.assertThat(user.getEmail()).isEqualTo(email);
        Assertions.assertThat(user.getPassword()).isEqualTo(password);
    }

}