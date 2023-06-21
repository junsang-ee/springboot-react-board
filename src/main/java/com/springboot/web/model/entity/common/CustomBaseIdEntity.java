package com.springboot.web.model.entity.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class CustomBaseIdEntity implements Persistable<String> {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name="idGenerator", strategy = "com.springboot.web.config.CustomBaseIdGenerator")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @JsonIgnore
    @Override
    public boolean isNew() {
        return id == null;
    }
}
