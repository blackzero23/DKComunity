package com.dokyun.DKComunity.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "post_comments_bad")
@Entity
@Getter
@NoArgsConstructor
public class PostCommentsBad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_comments_bad_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private PostComments postComments;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public PostCommentsBad(Member member, PostComments postComments) {
        this.member = member;
        this.postComments = postComments;
    }
}
