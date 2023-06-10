package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsBad;
import com.dokyun.DKComunity.dto.post.PostBadDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostBadRepository;
import com.dokyun.DKComunity.repository.PostRepository;
import com.dokyun.DKComunity.service.PostBadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostBadServiceImpl implements PostBadService {
    private final PostBadRepository postBadRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    @Override
    public void addPostBad(Long postId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Posts posts = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        PostsBad postsBad = new PostsBad(member, posts);
        postBadRepository.save(postsBad);

    }

    @Override
    public void deletePostBad(PostBadDto postBadDto) {
        memberRepository.findById(postBadDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        postRepository.findById(postBadDto.getPostId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        PostsBad postsBad = postBadRepository.findById(postBadDto.getPostBadId()).orElseThrow(() -> new IllegalArgumentException("싫어요가 존재하지 않습니다."));

        postBadRepository.delete(postsBad);
    }

    @Override
    public Page<PostBadDto> getPostGoodListOfMember(PostBadDto PostBadDto, Pageable pageable) {
        memberRepository.findById(PostBadDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return postBadRepository.findByMemberId(PostBadDto.getMemberId(), pageable).map(PostBadDto::of);
    }
}
