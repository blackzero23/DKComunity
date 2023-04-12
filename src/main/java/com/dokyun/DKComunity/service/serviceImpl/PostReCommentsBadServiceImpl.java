package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.PostReComments;
import com.dokyun.DKComunity.domain.PostReCommentsBad;
import com.dokyun.DKComunity.dto.post.PostReCommentsBadInfoDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostReCommentsBadRepository;
import com.dokyun.DKComunity.repository.PostReCommentsRepository;
import com.dokyun.DKComunity.service.PostReCommentsBadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostReCommentsBadServiceImpl implements PostReCommentsBadService {

    private final MemberRepository memberRepository;
    private final PostReCommentsRepository postReCommentsRepository;
    private final PostReCommentsBadRepository postReCommentsBadRepository;

    @Override
    public void addPostReCommentsBad(Long postReCommentsId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다."));
        PostReComments postReComments = postReCommentsRepository.findById(postReCommentsId).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));

        postReCommentsBadRepository.save(new PostReCommentsBad(member, postReComments));
    }

    @Override
    public void deletePostReCommentsBad(Long postReCommentsBadId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다."));
        PostReCommentsBad postReCommentsBad = postReCommentsBadRepository.findById(postReCommentsBadId).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));

        if (postReCommentsBad.getMember().getId() != member.getId()) {
            throw new IllegalArgumentException("해당 댓글의 작성자가 아닙니다.");
        }

        postReCommentsBadRepository.delete(postReCommentsBad);

    }

    @Override
    public Page<PostReCommentsBadInfoDto> getPostReCommentsBadListByMember(Long memberId, Pageable pageable) {
        memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다."));
        return postReCommentsBadRepository.findByMemberId(memberId, pageable).map(postReCommentsBad
                -> new PostReCommentsBadInfoDto(postReCommentsBad.getPostReComments().getId(), postReCommentsBad.getId(), postReCommentsBad.getPostReComments().getContent()));
    }
}
