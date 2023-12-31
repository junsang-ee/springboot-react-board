package com.springboot.web.model.entity;

import com.springboot.web.constants.BoardActivationStatus;
import com.springboot.web.constants.DisclosureStatusType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "board")
public class BoardEntity extends AbstractBaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BoardActivationStatus status;

    @Builder
    public BoardEntity(String name, DisclosureStatusType disclosureStatusType, UserEntity user) {
        this.name = name;
        this.createdBy = user;
        if (disclosureStatusType != null)
            this.setDisclosureStatusType(disclosureStatusType);
    }

    @PrePersist
    public void onPrevisionPersist() {
        this.status = BoardActivationStatus.NORMAL;
    }

}
