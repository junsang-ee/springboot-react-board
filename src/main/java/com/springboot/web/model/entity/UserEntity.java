package com.springboot.web.model.entity;

import com.springboot.web.constants.Role;
import com.springboot.web.model.entity.common.ModificationTimestampEntity;
import com.springboot.web.model.entity.count.FollowCountEntity;
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

    @Transient
    @OneToMany
    private List<BoardEntity> board;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "followCount")
    private FollowCountEntity followCount;

    @Builder
    public UserEntity(String userName, String password, String email,
                      Role role, FollowCountEntity followCount) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.email = email;
        this.followCount = followCount;
    }
}
