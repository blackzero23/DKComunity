package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsCategory;
import com.dokyun.DKComunity.domain.PostsGood;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostGoodRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PostCategoryRepository postCategoryRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostsGoodRepository postsGoodRepository;

    //생성
    @Test
    @DisplayName("포스트 좋아요 생성")
    void createPostsGood(){
        //given
        Member member = Member.builder().nickName("test").email("test@gmail.com").password("test").build();
        PostsCategory postsCategory = PostsCategory.builder().title("quant").build();
        Member savedMember = memberRepository.save(member);
        PostsCategory savedPostsCategory = postCategoryRepository.save(postsCategory);
        Posts posts = Posts.builder().member(savedMember).postsCategory(savedPostsCategory).content("postsCotent").title("title!!!").build();
        Posts savedPosts = postRepository.save(posts);
        PostsGood postsGood = PostsGood.builder().member(savedMember).posts(savedPosts).build();
        //when
        PostsGood savedPostsGood = postsGoodRepository.save(postsGood);

        //then
        Assertions.assertThat(savedPostsGood.getId()).isEqualTo(1L);

    }


    //삭제
    @Test
    @Transactional
    @DisplayName("포스트 좋아요 삭제")
    void deletePostsGood(){
        //given
        Member member = Member.builder().nickName("test").email("test@gmail.com").password("test").build();
        PostsCategory postsCategory = PostsCategory.builder().title("quant").build();
        Member savedMember = memberRepository.save(member);
        PostsCategory savedPostsCategory = postCategoryRepository.save(postsCategory);
        Posts posts = Posts.builder().member(savedMember).postsCategory(savedPostsCategory).content("postsCotent").title("title!!!").build();
        Posts savedPosts = postRepository.save(posts);
        PostsGood postsGood = PostsGood.builder().member(savedMember).posts(savedPosts).build();
        //when
        PostsGood savedPostsGood = postsGoodRepository.save(postsGood);
        postsGoodRepository.delete(savedPostsGood);

        //then
        Assertions.assertThat(0L).isEqualTo(postsGoodRepository.findAll().size());
    }

    @Test
    @DisplayName("포스트에 대한 좋아요 개수")
    void countPostsGoodByPosts(){
        //맴버 생성, 카테고리생성, 포스트 생성, 좋아요.
        Member member = Member.builder().nickName("test").email("test@gmail.com").password("test").build();
        PostsCategory postsCategory = PostsCategory.builder().title("quant").build();
        Member savedMember = memberRepository.save(member);
        PostsCategory savedPostsCategory = postCategoryRepository.save(postsCategory);
        Posts posts = Posts.builder().member(savedMember).postsCategory(savedPostsCategory).content("postsCotent").title("title!!!").build();
        Posts savedPosts = postRepository.save(posts);
        PostsGood postsGood = PostsGood.builder().member(savedMember).posts(savedPosts).build();
        PostsGood savedPostsGood = postsGoodRepository.save(postsGood);

        long countGood = postsGoodRepository.countByPosts(posts);

        Assertions.assertThat(countGood).isEqualTo(1);

        postsGoodRepository.delete(savedPostsGood);
        long count2 = postsGoodRepository.countByPosts(posts);
        Assertions.assertThat(count2).isEqualTo(0);

    }

}