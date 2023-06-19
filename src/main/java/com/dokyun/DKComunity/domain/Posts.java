package com.dokyun.DKComunity.domain;


import com.dokyun.DKComunity.util.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
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

    @Builder
    public Posts (PostsCategory postsCategory,String title, String content, Member member){
        this.postsCategory = postsCategory;
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public void updatePosts(String title, String content, PostsCategory postsCategory){
        this.title = title;
        this.content = content;
        this.postsCategory = postsCategory;
    }

}
