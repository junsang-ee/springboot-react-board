package com.springboot.web.model.entity;

import com.springboot.web.model.entity.common.TimestampSequentialEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "follow")
@Entity
public class FollowEntity extends TimestampSequentialEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_user")
    private UserEntity toUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_user")
    private UserEntity fromUser;
}
