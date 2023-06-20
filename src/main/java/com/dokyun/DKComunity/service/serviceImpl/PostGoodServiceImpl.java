package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsGood;
import com.dokyun.DKComunity.dto.post.PostGoodDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostGoodRepository;
import com.dokyun.DKComunity.repository.PostRepository;
import com.dokyun.DKComunity.service.PostGoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostGoodServiceImpl implements PostGoodService {

    private final PostGoodRepository postGoodRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Override
    public void addGood(PostGoodDto postGoodDto) {
        //회원 확인, 포스트 확인
        Member member = memberRepository.findById(postGoodDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Posts posts = postRepository.findById(postGoodDto.getPostId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        //좋아요 추가
        PostsGood.builder().posts(posts).member(member);
        PostsGood postsGood = PostsGood.CreatePostGood(member, posts);
        postGoodRepository.save(postsGood);
    }

    @Override
    public void deleteGood(PostGoodDto postGoodDto) {
        //회원 확인, 포스트 확인 좋아요 확인.
        Member member = memberRepository.findById(postGoodDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Posts posts = postRepository.findById(postGoodDto.getPostId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        PostsGood postsGood = postGoodRepository.findById(postGoodDto.getPostGoodId()).orElseThrow(() -> new IllegalArgumentException("좋아요가 존재하지 않습니다."));

        postGoodRepository.delete(postsGood);
    }

    @Override
    public Page<PostGoodDto> getPostGoodListOfMember(PostGoodDto postGoodDto, Pageable pageable) {
        Member member = memberRepository.findById(postGoodDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return postGoodRepository.findByMember(member, pageable).map(PostGoodDto::of);
    }

}
