package com.dokyun.DKComunity.domain;

import com.dokyun.DKComunity.util.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "post_comments")
public class PostComments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_comments_id")
    private Long id;

    @Column(nullable = false, length = 255)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Posts posts;



    public static PostComments createPostComments(String content, Member member, Posts posts){
        PostComments postComments = new PostComments();
        postComments.setContent(content);
        postComments.setMember(member);
        postComments.setPosts(posts);
        return postComments;
    }

    public void updatePostComments(String content) {
        this.setContent(content);
    }
}
