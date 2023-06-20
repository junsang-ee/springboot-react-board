package com.springboot.web.model.entity;

import com.springboot.web.model.entity.common.CustomBaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity(name = "board")
public class BoardEntity extends CustomBaseIdEntity {
}
