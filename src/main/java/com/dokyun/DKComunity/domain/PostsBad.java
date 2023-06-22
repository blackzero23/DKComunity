package com.dokyun.DKComunity.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "posts_bad")
public class PostsBad {
    @Id
    @Column(name = "posts_bad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Posts posts;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Builder
    public PostsBad(Member member, Posts posts) {
        this.member = member;
        this.posts = posts;
    }

}
