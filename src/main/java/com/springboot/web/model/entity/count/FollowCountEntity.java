package com.springboot.web.model.entity.count;

import com.springboot.web.model.entity.common.TimestampSequentialEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "follow_count")
public class FollowCountEntity extends TimestampSequentialEntity {

    private long followerCount;

    private long followingCount;

    @PrePersist
    public void onPrevisionPersist() {
        this.followerCount = 0;
        this.followingCount = 0;
    }
}
