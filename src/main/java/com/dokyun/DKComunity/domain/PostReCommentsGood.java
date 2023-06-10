package com.dokyun.DKComunity.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "post_recomments_good")
@Entity
@Getter
@NoArgsConstructor
public class PostReCommentsGood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostReComments postReComments;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public PostReCommentsGood(Member member, PostReComments postReComments) {
        this.member = member;
        this.postReComments = postReComments;
    }
}
