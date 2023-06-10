package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.PostComments;
import com.dokyun.DKComunity.domain.PostReComments;
import com.dokyun.DKComunity.dto.post.PostReCommentCreateDto;
import com.dokyun.DKComunity.dto.post.PostReCommentDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostCommentsRepository;
import com.dokyun.DKComunity.repository.PostReCommentsRepository;
import com.dokyun.DKComunity.service.PostReCommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostReCommentServiceImpl implements PostReCommentsService{
    private final MemberRepository memberRepository;
    private final PostCommentsRepository postCommentsRepository;
    private final PostReCommentsRepository postReCommentsRepository;
    @Override
    public void addReComment(PostReCommentCreateDto postReCommentCreateDto) {
        Member member = memberRepository.findById(postReCommentCreateDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        PostComments postComments = postCommentsRepository.findById(postReCommentCreateDto.getPostCommentId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));

        PostReComments postReComments = new PostReComments(postReCommentCreateDto.getContent(), member, postComments);

        postReCommentsRepository.save(postReComments);
    }

    @Override
    public void updateReComment(PostReCommentDto postReCommentDto) {
        memberRepository.findById(postReCommentDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        PostReComments postReComments = postReCommentsRepository.findById(postReCommentDto.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 대댓글입니다."));
        postReComments.update(postReCommentDto.getContent());

        postReCommentsRepository.save(postReComments);
    }

    @Override
    public void deleteReComment(PostReCommentDto postReCommentDto) {
        memberRepository.findById(postReCommentDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        PostReComments postReComments = postReCommentsRepository.findById(postReCommentDto.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 대댓글입니다."));

        postReCommentsRepository.delete(postReComments);

    }

    @Override
    public Page<PostReCommentDto> getReCommentListOfComment(PostReCommentDto postReCommentDto) {
        return null;
    }
}
