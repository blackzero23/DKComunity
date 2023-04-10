package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.PostComments;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.dto.post.PostCommentCreateDto;
import com.dokyun.DKComunity.dto.post.PostCommentInfoDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostCommentsRepository;
import com.dokyun.DKComunity.repository.PostRepository;
import com.dokyun.DKComunity.service.PostCommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCommentsServiceImpl implements PostCommentsService {

    private final PostCommentsRepository postCommentsRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Override
    public PostCommentInfoDto addPostComment(PostCommentCreateDto postCommentCreateDto) {
        //맴버 확인, 포스트 확인
        Member member = memberRepository.findById(postCommentCreateDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Posts posts = postRepository.findById(postCommentCreateDto.getPostId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        //댓글 생성
        PostComments postComments = PostComments.createPostComments(postCommentCreateDto.getContent(), member, posts);
        PostComments savedPostComments = postCommentsRepository.save(postComments);

        return new PostCommentInfoDto(savedPostComments);
    }

    @Override
    public PostCommentInfoDto updatePostComment(PostCommentInfoDto postCommentInfoDto) {
        //맴버 확인 , 댓글 확인
        memberRepository.findById(postCommentInfoDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        PostComments postComments = postCommentsRepository.findById(postCommentInfoDto.getPostCommentId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        //댓글 수정
        postComments.updatePostComments(postCommentInfoDto.getContent());

        postCommentsRepository.save(postComments);

        return new PostCommentInfoDto(postComments);
    }

    @Override
    public PostCommentInfoDto getPostComment(Long id) {
        PostComments postComments = postCommentsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        return new PostCommentInfoDto(postComments);
    }

    @Override
    public Page<PostCommentInfoDto> getPostCommentByPostId(Long postId, Pageable pageable) {
        postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        return postCommentsRepository.findByPostsId(postId, pageable).map(PostCommentInfoDto::new);
    }

    @Override
    public Page<PostCommentInfoDto> getPostCommentByMemberId(Long memberId, Pageable pageable) {
        memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return postCommentsRepository.findByMemberId(memberId, pageable).map(PostCommentInfoDto::new);
    }

    @Override
    public void deletePostComment(Long commentId,Long memberId) {
        memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        PostComments postComments = postCommentsRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        postCommentsRepository.delete(postComments);
    }
}
