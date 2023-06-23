package com.springboot.web.model.entity;

import com.springboot.web.constants.Role;
import com.springboot.web.model.entity.common.CreationTimestampEntity;
import com.springboot.web.model.entity.common.ModificationTimestampEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity extends ModificationTimestampEntity {
    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<BoardEntity> board;

    @Builder
    public UserEntity(String userName, String password, String email, Role role){
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}
