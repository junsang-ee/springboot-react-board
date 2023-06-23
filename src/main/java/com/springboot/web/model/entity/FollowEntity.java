package com.springboot.web.model.entity;

import com.springboot.web.model.entity.common.TimestampSequentialEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity(name = "follow")
public class FollowEntity extends TimestampSequentialEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_user")
    private UserEntity toUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_user")
    private UserEntity fromUser;
}
