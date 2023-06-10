package com.dokyun.DKComunity.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "post_recomments")
@NoArgsConstructor
public class PostReComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_recomment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostComments postComments;

    private String content;

    public PostReComments(String content ,Member member, PostComments postComments) {
        this.member = member;
        this.postComments = postComments;
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }
}
