package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.PostComments;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsCategory;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostCategoryRepository;
import com.dokyun.DKComunity.repository.PostCommentsRepository;
import com.dokyun.DKComunity.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostCommentsServiceTest {
    @Autowired
    PostCommentsRepository postCommentsRepository;
    @Autowired
    PostCommentsService postCommentsService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostService postService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PostCategoryRepository postCategoryRepository;
    @Test
    @DisplayName("댓글 추가")
    void addPostComment() {
//        //given
//        PostInfoDto post = postService.createPost(new PostCreateDto("test", "test", 1L));
//
//        PostCommentCreateDto postCommentCreateDto = new PostCommentCreateDto();
//        postCommentCreateDto.setPostId(1L);
//        postCommentCreateDto.setMemberId(1L);
//        postCommentCreateDto.setContent("댓글 내용");
//        //when
//        PostCommentInfoDto postCommentInfoDto = postCommentsService.addPostComment(postCommentCreateDto);
//        //then
//        assertNotNull(postCommentInfoDto);
//        assertEquals(postCommentInfoDto.getPostId(), postCommentCreateDto.getPostId());
//        assertEquals(postCommentInfoDto.getMemberId(), postCommentCreateDto.getMemberId());
//        assertEquals(postCommentInfoDto.getContent(), postCommentCreateDto.getContent());
        Member member = Member.builder().nickName("test")
                .password("nickName")
                .email("test@gmail.com")
                .build();
        Member savedMember = memberRepository.save(member);
        PostsCategory category = PostsCategory.builder().title("test").build();
        PostsCategory savedCategory = postCategoryRepository.save(category);
        Posts posts = Posts.builder()
                .postsCategory(savedCategory)
                .title("test")
                .content("test")
                .member(savedMember)
                .build();

        Posts savedPosts = postRepository.save(posts);
        PostComments test = PostComments.createPostComments("test", savedMember, savedPosts);


    }


}