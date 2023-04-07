package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.domain.PostsCategory;
import com.dokyun.DKComunity.repository.PostCategoryRepository;
import com.dokyun.DKComunity.service.serviceImpl.PostCategoryServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostCategoryServiceImplTest {

    @Autowired
    private PostCategoryServiceImpl postCategoryService;
    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @Test
    @DisplayName("게시글 카테고리 생성")
    void createPostCategory() {
        PostsCategory postsCategory = new PostsCategory();
        postsCategory.setTitle("test");
        PostsCategory savedCategory = postCategoryRepository.save(postsCategory);

        assertEquals(savedCategory.getTitle(), postsCategory.getTitle());
        Assertions.assertThat(savedCategory.getTitle()).isEqualTo(postsCategory.getTitle());

    }

    @Test
    @DisplayName("게시글 카테고리 조회")
    void getPostCategory() {
        PostsCategory postsCategory = new PostsCategory();
        postsCategory.setTitle("test");
        PostsCategory savedCategory = postCategoryRepository.save(postsCategory);

        PostsCategory findCategory = postCategoryRepository.findById(savedCategory.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));

        assertEquals(findCategory.getTitle(), postsCategory.getTitle());
        Assertions.assertThat(findCategory.getTitle()).isEqualTo(postsCategory.getTitle());
    }

    @Test
    @DisplayName("게시글 카테고리 수정")
    void updatePostCategory() {
        PostsCategory postsCategory = new PostsCategory();
        postsCategory.setTitle("test");
        PostsCategory savedCategory = postCategoryRepository.save(postsCategory);

        PostsCategory findCategory = postCategoryRepository.findById(savedCategory.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
        findCategory.setTitle("test2");
        PostsCategory updatedCategory = postCategoryRepository.save(findCategory);

        assertEquals(updatedCategory.getTitle(), findCategory.getTitle());
        Assertions.assertThat(updatedCategory.getTitle()).isEqualTo(findCategory.getTitle());
    }

    @Test
    @DisplayName("게시글 카테고리 삭제")
    void deletePostCategory() {
        PostsCategory postsCategory = new PostsCategory();
        postsCategory.setTitle("test");
        PostsCategory savedCategory = postCategoryRepository.save(postsCategory);

        PostsCategory findCategory = postCategoryRepository.findById(savedCategory.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
        postCategoryRepository.delete(findCategory);

        PostsCategory deletedCategory = postCategoryRepository.findById(savedCategory.getId()).orElse(null);

        assertNull(deletedCategory);
    }


}