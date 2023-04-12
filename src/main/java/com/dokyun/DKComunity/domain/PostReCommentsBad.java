package com.dokyun.DKComunity.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "post_re_comments_bad")
@Getter
public class PostReCommentsBad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostReComments postReComments;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    protected PostReCommentsBad() {
    }

    public PostReCommentsBad(Member member, PostReComments postReComments) {
        this.member = member;
        this.postReComments = postReComments;
    }
}
