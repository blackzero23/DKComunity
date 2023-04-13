package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.post.PostCommentCreateDto;
import com.dokyun.DKComunity.dto.post.PostCommentInfoDto;
import com.dokyun.DKComunity.dto.post.PostCreateDto;
import com.dokyun.DKComunity.dto.post.PostInfoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostCommentsServiceTest {
    @Autowired
    PostCommentsService postCommentsService;

    @Autowired
    PostService postService;
    @Test
    @DisplayName("댓글 추가")
    void addPostComment() {
        //given
        PostInfoDto post = postService.createPost(new PostCreateDto("test", "test", 1L));

        PostCommentCreateDto postCommentCreateDto = new PostCommentCreateDto();
        postCommentCreateDto.setPostId(1L);
        postCommentCreateDto.setMemberId(1L);
        postCommentCreateDto.setContent("댓글 내용");
        //when
        PostCommentInfoDto postCommentInfoDto = postCommentsService.addPostComment(postCommentCreateDto);
        //then
        assertNotNull(postCommentInfoDto);
        assertEquals(postCommentInfoDto.getPostId(), postCommentCreateDto.getPostId());
        assertEquals(postCommentInfoDto.getMemberId(), postCommentCreateDto.getMemberId());
        assertEquals(postCommentInfoDto.getContent(), postCommentCreateDto.getContent());
    }


}