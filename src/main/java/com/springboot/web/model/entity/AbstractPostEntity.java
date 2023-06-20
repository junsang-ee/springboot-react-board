package com.springboot.web.model.entity;

import com.springboot.web.constants.PostActivationStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractPostEntity extends AbstractBaseEntity{
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PostActivationStatus status;

    @PrePersist
    public void onPrevisionPersist() {
        this.status = PostActivationStatus.NORMAL;
    }

}
