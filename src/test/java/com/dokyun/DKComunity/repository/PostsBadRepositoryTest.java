package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsBad;
import com.dokyun.DKComunity.domain.PostsCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsBadRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PostCategoryRepository postCategoryRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostsBadRepository postsBadRepository;

    //생성
    @DisplayName("포스트 생성")
    @Test
    void createPostsBad() {
        //given
        Member member = Member.builder().nickName("test").email("test@gmail.com").password("test").build();
        PostsCategory postsCategory = PostsCategory.builder().title("quant").build();
        Member savedMember = memberRepository.save(member);
        PostsCategory savedPostsCategory = postCategoryRepository.save(postsCategory);
        Posts posts = Posts.builder().member(savedMember).postsCategory(savedPostsCategory).content("postsCotent").title("title!!!").build();
        Posts savedPosts = postRepository.save(posts);
        PostsBad postsBad = PostsBad.builder().member(savedMember).posts(posts).build();
        //when
        PostsBad savedPostsBad = postsBadRepository.save(postsBad);
        //then
        Assertions.assertThat(savedPostsBad.getId()).isEqualTo(1L);
    }

    //삭제
    @Test
    @DisplayName("포스트 싫어요 삭제")
    @Transactional
    void deletePostsBad() {
        //given
        Member member = Member.builder().nickName("test").email("test@gmail.com").password("test").build();
        PostsCategory postsCategory = PostsCategory.builder().title("quant").build();
        Member savedMember = memberRepository.save(member);
        PostsCategory savedPostsCategory = postCategoryRepository.save(postsCategory);
        Posts posts = Posts.builder().member(savedMember).postsCategory(savedPostsCategory).content("postsCotent").title("title!!!").build();
        Posts savedPosts = postRepository.save(posts);
        PostsBad postsBad = PostsBad.builder().member(savedMember).posts(posts).build();
        //when
        PostsBad savedPostsBad = postsBadRepository.save(postsBad);
        postsBadRepository.delete(savedPostsBad);

        //then
        Assertions.assertThat(0L).isEqualTo(postsBadRepository.findAll().size());
    }

    @DisplayName("포스트에 대한 싫어요 개수")
    @Test
    void countPostsBad() {
        //맴버 생성, 카테고리생성, 포스트 생성, 좋아요.
        ///given
        Member member = Member.builder().nickName("test").email("test@gmail.com").password("test").build();
        PostsCategory postsCategory = PostsCategory.builder().title("quant").build();
        Member savedMember = memberRepository.save(member);
        PostsCategory savedPostsCategory = postCategoryRepository.save(postsCategory);
        Posts posts = Posts.builder().member(savedMember).postsCategory(savedPostsCategory).content("postsCotent").title("title!!!").build();
        Posts savedPosts = postRepository.save(posts);
        PostsBad postsBad = PostsBad.builder().member(savedMember).posts(posts).build();
        //when
        postsBadRepository.save(postsBad);
        //then
        Long countBad = postsBadRepository.countByPosts(savedPosts);

        Assertions.assertThat(countBad).isEqualTo(1);

    }

}