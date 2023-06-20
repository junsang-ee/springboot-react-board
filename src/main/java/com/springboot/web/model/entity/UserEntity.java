package com.springboot.web.model.entity;

import com.springboot.web.model.entity.common.CreationLocalDateTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity extends CreationLocalDateTimeEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany
    private List<BoardEntity> board;

    @Builder
    public UserEntity(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
