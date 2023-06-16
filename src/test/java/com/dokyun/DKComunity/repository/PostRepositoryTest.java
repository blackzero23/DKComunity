package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostCategoryRepository postCategoryRepository;
    @Autowired
    MemberRepository memberRepository;

//    PostsCategory postsCategory;
//    Posts posts;

//    @BeforeEach
//    void setUp() {
//        postsCategory = new PostsCategory();
//        postsCategory.setTitle("test");
//        postCategoryRepository.save(postsCategory);
//
//        Member member = Member.builder()
//                .email("test@gmail.com")
//                .password("test")
//                .nickName("test")
//                .build();
//
//        memberRepository.save(member);
//
//        Posts posts = Posts.builder()
//                .postsCategory(postsCategory)
//                .title("test")
//                .content("test")
//                .member(member)
//                .build();
//
//        postRepository.save(posts);
//    }
//
//    @AfterEach
//    void tearDown() {
//        postRepository.delete(posts);
//        postCategoryRepository.delete(postsCategory);
//    }

    @Test
    @DisplayName("게시글 생성")
    void createPost() {
        PostsCategory postsCategory = new PostsCategory();
        postsCategory.setTitle("test");
        postCategoryRepository.save(postsCategory);

        Member member = Member.builder()
                .email("test@gmail.com")
                .password("test")
                .nickName("test")
                .build();

        memberRepository.save(member);

        Posts posts = Posts.builder()
                .postsCategory(postsCategory)
                .title("test")
                .content("test")
                .member(member)
                .build();
        Posts savedPost = postRepository.save(posts);

        assertEquals(savedPost.getTitle(), posts.getTitle());
        assertEquals(savedPost.getContent(), posts.getContent());
        assertEquals(savedPost.getPostsCategory().getTitle(), posts.getPostsCategory().getTitle());
    }

    @Test
    @DisplayName("게시글 단일 조회")
    @Transactional
    void getPost() {

        PostsCategory postsCategory = new PostsCategory();
        postsCategory.setTitle("test");
        postCategoryRepository.save(postsCategory);

        Member member = Member.builder()
                .email("test@gmail.com")
                .password("test")
                .nickName("test")
                .build();

        memberRepository.save(member);

        Posts posts = Posts.builder()
                .postsCategory(postsCategory)
                .title("test")
                .content("test")
                .member(member)
                .build();
        Posts savedPost = postRepository.save(posts);

        Posts findPost = postRepository.findById(posts.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        assertEquals(findPost.getTitle(), posts.getTitle());
        assertEquals(findPost.getContent(), posts.getContent());
        assertEquals(findPost.getPostsCategory().getTitle(), posts.getPostsCategory().getTitle());
    }

    @Test
    @DisplayName("게시글 수정")
    @Transactional
    void updatePost() {
        PostsCategory postsCategory = new PostsCategory();
        postsCategory.setTitle("test");
        postCategoryRepository.save(postsCategory);

        Member member = Member.builder()
                .email("test@gmail.com")
                .password("test")
                .nickName("test")
                .build();

        memberRepository.save(member);

        Posts posts = Posts.builder()
                .postsCategory(postsCategory)
                .title("test")
                .content("test")
                .member(member)
                .build();
        Posts savedPost = postRepository.save(posts);



        Posts findPost = postRepository.findById(posts.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        findPost.setTitle("test2");
        findPost.setContent("test2");
        Posts updatedPost = postRepository.save(findPost);

        assertEquals(updatedPost.getTitle(), findPost.getTitle());
        assertEquals(updatedPost.getContent(), findPost.getContent());
        assertEquals(updatedPost.getPostsCategory().getTitle(), findPost.getPostsCategory().getTitle());
    }

    @Test
    @DisplayName("게시글 삭제")
    @Transactional
    void deletePost() {
        PostsCategory postsCategory = new PostsCategory();
        postsCategory.setTitle("test");
        postCategoryRepository.save(postsCategory);

        Member member = Member.builder()
                .email("test@gmail.com")
                .password("test")
                .nickName("test")
                .build();

        memberRepository.save(member);

        Posts posts = Posts.builder()
                .postsCategory(postsCategory)
                .title("test")
                .content("test")
                .member(member)
                .build();
        Posts savedPost = postRepository.save(posts);


        postRepository.delete(posts);

        assertThrows(IllegalArgumentException.class, () -> {
            postRepository.findById(posts.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        });
    }

}