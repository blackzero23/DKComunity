package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.PostComments;
import com.dokyun.DKComunity.domain.PostCommentsBad;
import com.dokyun.DKComunity.dto.post.PostCommentsBadInfoDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostCommentsBadRepository;
import com.dokyun.DKComunity.repository.PostCommentsRepository;
import com.dokyun.DKComunity.service.PostCommentsBadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCommentsBadServiceImpl implements PostCommentsBadService {
    private final MemberRepository memberRepository;
    private final PostCommentsRepository postCommentsRepository;
    private final PostCommentsBadRepository postCommentsBadRepository;
    @Override
    public void addPostBad(Long postId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        PostComments postComments = postCommentsRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));

        postCommentsBadRepository.save(new PostCommentsBad(member, postComments));
    }

    @Override
    public void deletePostBad(Long postCommentsBadId, Long memberId) {
        memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        postCommentsBadRepository.findById(postCommentsBadId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 싫어요입니다."));
        postCommentsBadRepository.deleteById(postCommentsBadId);
    }

    @Override
    public Page<PostCommentsBadInfoDto> getPostGoodListOfMember(Long memberId, Pageable pageable) {
        memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return postCommentsBadRepository.findByMemberId(memberId, pageable).map(postCommentsBad ->
                new PostCommentsBadInfoDto(postCommentsBad.getId(), postCommentsBad.getMember().getId()
                        , postCommentsBad.getPostComments().getId(), postCommentsBad.getPostComments().getContent()));
    }
}
