package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsCategory;
import com.dokyun.DKComunity.dto.post.PostCreateDto;
import com.dokyun.DKComunity.dto.post.PostInfoDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostCategoryRepository;
import com.dokyun.DKComunity.repository.PostRepository;
import com.dokyun.DKComunity.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final PostCategoryRepository postCategoryRepository;

    //TODO: 시간상 넘어가지만 차후 공통 findById duplicate 만들어서 분리 시키기
    @Override
    public PostInfoDto createPost(PostCreateDto postCreateDto) {
        Member member = memberRepository.findById(postCreateDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        PostsCategory postsCategory = postCategoryRepository.findById(postCreateDto.getCategoryId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));

        Posts posts = Posts.builder()
                .postsCategory(postsCategory)
                .title(postCreateDto.getTitle())
                .content(postCreateDto.getContent())
                .member(member)
                .build();

        Posts savedPost = postRepository.save(posts);

        return PostInfoDto.of(savedPost);
    }

    @Override
    public PostInfoDto getPost(Long id) {
        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        return PostInfoDto.of(posts);
    }

    @Override
    public Page<PostInfoDto> getPostList(Pageable pageable) {
        return postRepository.findAll(pageable).map(PostInfoDto::of);
    }

    @Override
    public PostInfoDto updatePost(PostInfoDto postInfoDto) {
        Posts posts = postRepository.findById(postInfoDto.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        //TODO: 카테고리 ID가 조작될 우려는 없지만 get 말고 다른방법을 사용하든 위 처럼 Exception 뛰우는걸로 방어.
        posts.updatePosts(postInfoDto.getTitle(), postInfoDto.getContent(),postCategoryRepository.findById(postInfoDto.getPostCateId()).get());

        postRepository.save(posts);

        return PostInfoDto.of(posts);
    }

    @Override
    public void deletePost(Long id) {
        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        postRepository.delete(posts);
    }
}
