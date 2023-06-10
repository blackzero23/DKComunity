package com.dokyun.DKComunity.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "posts_good")
public class PostsGood {
    @Id
    @Column(name = "posts_good_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Posts posts;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public static PostsGood CreatePostGood(Member member, Posts posts) {
        PostsGood postsGood = new PostsGood();
        postsGood.setMember(member);
        postsGood.setPosts(posts);
        return postsGood;
    }
}
