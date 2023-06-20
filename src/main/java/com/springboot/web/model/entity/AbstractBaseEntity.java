package com.springboot.web.model.entity;

import com.springboot.web.constants.DisclosureStatusType;
import com.springboot.web.model.entity.common.CreationLocalDateTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBaseEntity extends CreationLocalDateTimeEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DisclosureStatusType disclosureStatusType = DisclosureStatusType.PUBLIC;
}
