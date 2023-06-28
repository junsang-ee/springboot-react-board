package com.springboot.web.model.entity;

import com.springboot.web.constants.BoardActivationStatus;
import com.springboot.web.constants.DisclosureStatusType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "board")
@Entity
public class BoardEntity extends AbstractBaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BoardActivationStatus status;

    @Builder
    public BoardEntity(String name, DisclosureStatusType disclosureStatusType, UserEntity user) {
        this.name = name;
        this.setCreatedBy(user);
        if (disclosureStatusType != null)
            this.setDisclosureStatusType(disclosureStatusType);
    }

    @PrePersist
    public void onPrevisionPersist() {
        this.status = BoardActivationStatus.NORMAL;
    }

}
