package com.dokyun.DKComunity.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "post_comments_good")
@NoArgsConstructor
public class PostCommentsGood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_comments_good_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private PostComments postComments;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public PostCommentsGood(Member member, PostComments postComments) {
        this.member = member;
        this.postComments = postComments;
    }

}
