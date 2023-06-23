package com.springboot.web.model.entity.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public abstract class ModificationTimestampEntity extends CreationTimestampEntity {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
