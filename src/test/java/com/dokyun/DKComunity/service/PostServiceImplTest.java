package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsCategory;
import com.dokyun.DKComunity.repository.PostCategoryRepository;
import com.dokyun.DKComunity.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostCategoryRepository postCategoryRepository;

    PostsCategory postsCategory;
    Posts posts;
    @BeforeEach
    void setUp() {
        postsCategory = new PostsCategory();
        postsCategory.setTitle("test");
        postCategoryRepository.save(postsCategory);

        posts = new Posts();
        posts.setTitle("test");
        posts.setContent("test");
        posts.setPostsCategory(postsCategory);
        postRepository.save(posts);
    }

//    @AfterEach
//    void tearDown() {
//        postRepository.delete(posts);
//        postCategoryRepository.delete(postsCategory);
//    }

    @Test
    @DisplayName("게시글 생성")
    void createPost() {
        Posts posts = new Posts();
        posts.setTitle("test");
        posts.setContent("test");
        posts.setPostsCategory(postsCategory);
        Posts savedPost = postRepository.save(posts);

        assertEquals(savedPost.getTitle(), posts.getTitle());
        assertEquals(savedPost.getContent(), posts.getContent());
        assertEquals(savedPost.getPostsCategory().getTitle(), posts.getPostsCategory().getTitle());
    }

    @Test
    @DisplayName("게시글 조회")
    @Transactional
    void getPost() {
        Posts findPost = postRepository.findById(posts.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        assertEquals(findPost.getTitle(), posts.getTitle());
        assertEquals(findPost.getContent(), posts.getContent());
        assertEquals(findPost.getPostsCategory().getTitle(), posts.getPostsCategory().getTitle());
    }

    @Test
    @DisplayName("게시글 수정")
    @Transactional
    void updatePost() {
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
    void deletePost(){
        postRepository.delete(posts);

        assertThrows(IllegalArgumentException.class, () -> {
            postRepository.findById(posts.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        });
    }

}