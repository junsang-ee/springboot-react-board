package com.springboot.web.model.entity;

import com.springboot.web.constants.DisclosureStatusType;
import com.springboot.web.constants.PostActivationStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "reply")
@Entity
public class ReplyEntity extends AbstractPostEntity {
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentPost", nullable = false)
    private PostEntity paremtPost;

    @Builder
    public ReplyEntity(String content,
                       PostEntity paremtPost,
                       String password,
                       DisclosureStatusType disclosureStatusType,
                       UserEntity createdBy) {
        this.content = content;
        this.paremtPost = paremtPost;
        this.setPassword(password);
        this.setDisclosureStatusType(disclosureStatusType);
        this.setCreatedBy(createdBy);

    }
}
