package com.springboot.web.model.entity.count;

import com.springboot.web.model.entity.UserEntity;
import com.springboot.web.model.entity.common.TimestampSequentialEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "follow_count")
public class FollowCountEntity extends TimestampSequentialEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private long followerCount;

    private long followingCount;

    @PrePersist
    public void onPrevisionPersist() {
        this.followerCount = 0;
        this.followingCount = 0;
    }
}
