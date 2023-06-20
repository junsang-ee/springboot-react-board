package com.springboot.web.model.entity;

import com.springboot.web.constants.DisclosureStatusType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "post")
public class PostEntity extends AbstractPostEntity {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentBoard", nullable = false)
    private BoardEntity parentBoard;

    @Builder
    public PostEntity(String title, String content, DisclosureStatusType disclosureStatusType, BoardEntity board) {
        this.title = title;
        this.content = content;
        this.parentBoard = board;
        this.setDisclosureStatusType(disclosureStatusType);
    }
}
