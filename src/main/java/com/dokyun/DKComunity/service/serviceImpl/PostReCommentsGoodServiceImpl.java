package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.PostReComments;
import com.dokyun.DKComunity.domain.PostReCommentsGood;
import com.dokyun.DKComunity.dto.post.PostReCommentsGoodInfoDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostReCommentsGoodRepository;
import com.dokyun.DKComunity.repository.PostReCommentsRepository;
import com.dokyun.DKComunity.service.PostReCommentsGoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostReCommentsGoodServiceImpl implements PostReCommentsGoodService {
    private final MemberRepository memberRepository;
    private final PostReCommentsRepository postReCommentsRepository;
    private final PostReCommentsGoodRepository postReCommentsGoodRepository;

    @Override
    public void save(Long postReCommentId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        PostReComments postReComments = postReCommentsRepository.findById(postReCommentId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 대댓글입니다."));

        postReCommentsGoodRepository.save(new PostReCommentsGood(member, postReComments));
    }

    @Override
    public void delete(Long postReCommentGoodId, Long memberId) {
        memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        postReCommentsGoodRepository.findById(postReCommentGoodId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 좋아요입니다."));
        postReCommentsGoodRepository.deleteById(postReCommentGoodId);
    }

    @Override
    public Page<PostReCommentsGoodInfoDto> getPostReCommentsGoodListByMemberId(Long memberId, Pageable pageable) {
        memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return postReCommentsGoodRepository.findByMemberId(memberId, pageable).map(postReCommentsGood ->
                new PostReCommentsGoodInfoDto(postReCommentsGood.getId(), postReCommentsGood.getMember().getId()
                        , postReCommentsGood.getPostReComments().getId(), postReCommentsGood.getPostReComments().getContent()));
    }
}
