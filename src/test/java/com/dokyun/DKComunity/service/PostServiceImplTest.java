package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsCategory;
import com.dokyun.DKComunity.dto.member.MemberSignupDto;
import com.dokyun.DKComunity.dto.post.PostCateCreateDto;
import com.dokyun.DKComunity.dto.post.PostCreateDto;
import com.dokyun.DKComunity.dto.post.PostInfoDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostCategoryRepository;
import com.dokyun.DKComunity.repository.PostRepository;
import com.dokyun.DKComunity.service.serviceImpl.MemberServiceImpl;
import com.dokyun.DKComunity.service.serviceImpl.PostCategoryServiceImpl;
import com.dokyun.DKComunity.service.serviceImpl.PostServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PostServiceImplTest {
    @Autowired
    PostService postService;
    @Autowired
    MemberService memberService;
    @Autowired
    PostCategoryService postCategoryService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PostCategoryRepository postCategoryRepository;
    @Autowired
    PostRepository postRepository;


    @DisplayName("게시판 생성")
    @Test
    void postCreate(){
        //given
        MemberSignupDto memberSignupDto = MemberSignupDto.builder().nickName("test").email("test@gmail.com").password("test").build();
        memberService.signup(memberSignupDto);
        postCategoryService.createPostCategory(PostCateCreateDto.builder().title("quant").build());
        Optional<PostsCategory> postsCategory = postCategoryRepository.findByTitle("quant");
        PostInfoDto post = postService.createPost(PostCreateDto.builder().categoryId(1L).memberId(1L).content("내용 없음").title("테스트한다!").build());
        //when
        Optional<Posts> posts = postRepository.findById(1L);

        //then
        Posts post1 = null;
        if(posts.isPresent()){
            post1 = posts.get();
            Assertions.assertThat("테스트한다!").isEqualTo(post1.getTitle());
        }
    }

    @DisplayName("게시글 수정")
    @Test
    void postSearch(){
        //given
        MemberSignupDto memberSignupDto = MemberSignupDto.builder().nickName("test").email("test@gmail.com").password("test").build();
        memberService.signup(memberSignupDto);
        postCategoryService.createPostCategory(PostCateCreateDto.builder().title("quant").build());
        Optional<PostsCategory> postsCategory = postCategoryRepository.findByTitle("quant");
        PostInfoDto post = postService.createPost(PostCreateDto.builder().categoryId(1L).memberId(1L).content("내용 없음").title("테스트한다!").build());
        //when
        post.setTitle("updateTitle");
        post.setContent("updateContent");

        PostInfoDto postInfoDto = postService.updatePost(post);

        //then

        Assertions.assertThat("updateTitle").isEqualTo(postInfoDto.getTitle());
        Assertions.assertThat("updateContent").isEqualTo(postInfoDto.getContent());
    }

    @DisplayName("게시글 Id 단일 조회")
    @Test
    void postGetId(){
        //given
        MemberSignupDto memberSignupDto = MemberSignupDto.builder().nickName("test").email("test@gmail.com").password("test").build();
        memberService.signup(memberSignupDto);
        postCategoryService.createPostCategory(PostCateCreateDto.builder().title("quant").build());
        Optional<PostsCategory> postsCategory = postCategoryRepository.findByTitle("quant");
        PostInfoDto post = postService.createPost(PostCreateDto.builder().categoryId(1L).memberId(1L).content("내용 없음").title("테스트한다!").build());
        //when
        PostInfoDto findPostsInfoDto = postService.getPost(1L);
        //then
        Assertions.assertThat(findPostsInfoDto.getTitle()).isEqualTo("테스트한다!");
    }

    @DisplayName("게시글 삭제")
    @Test
    void postserviceDelete(){
        //given
        MemberSignupDto memberSignupDto = MemberSignupDto.builder().nickName("test").email("test@gmail.com").password("test").build();
        memberService.signup(memberSignupDto);
        postCategoryService.createPostCategory(PostCateCreateDto.builder().title("quant").build());
        Optional<PostsCategory> postsCategory = postCategoryRepository.findByTitle("quant");
        PostInfoDto post = postService.createPost(PostCreateDto.builder().categoryId(1L).memberId(1L).content("내용 없음").title("테스트한다!").build());
        //when
        postService.deletePost(1L);
        List<Posts> postsList = postRepository.findAll();
        //then
        Assertions.assertThat(postsList.size()).isEqualTo(0);
    }


}