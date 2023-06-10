package com.dokyun.DKComunity.domain;


import com.dokyun.DKComunity.util.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 1000)
    private String content;

    //firstData 0
    @Column(columnDefinition = "bigint default 0")
    private Long hit;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostsCategory postsCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public static Posts createPosts(String title, String content, Member member, PostsCategory postsCategory){
        Posts posts = new Posts();
        posts.setTitle(title);
        posts.setContent(content);
        posts.setPostsCategory(postsCategory);
        return posts;
    }

    public void updatePosts(String title, String content){
        this.setTitle(title);
        this.setContent(content);
        this.setPostsCategory(postsCategory);
    }

    public static Posts toEntity(Long id, String title, String content, Long hit, PostsCategory postsCategory){
        Posts posts = new Posts();
        posts.setId(id);
        posts.setTitle(title);
        posts.setContent(content);
        posts.setHit(hit);
        posts.setPostsCategory(postsCategory);
        return posts;
    }

}
