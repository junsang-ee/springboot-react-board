package com.springboot.web.model.entity;

import com.springboot.web.constants.DisclosureStatusType;
import com.springboot.web.model.entity.common.CreationTimestampEntity;
import com.springboot.web.model.entity.common.ModificationTimestampEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBaseEntity extends ModificationTimestampEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DisclosureStatusType disclosureStatusType = DisclosureStatusType.PUBLIC;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;
}
