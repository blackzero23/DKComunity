package com.dokyun.DKComunity.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
//@Setter
@Table(name = "posts_good")
@NoArgsConstructor
public class PostsGood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_good_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Posts posts;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @Builder
    public PostsGood(Member member, Posts posts) {
        this.member = member;
        this.posts = posts;
    }
}
