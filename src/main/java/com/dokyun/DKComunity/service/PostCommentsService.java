package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.post.PostCommentCreateDto;
import com.dokyun.DKComunity.dto.post.PostCommentInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostCommentsService {
    //추가 수정 삭제 조회(단일 조회, 포스트ID로 조회, 회원 ID로 조회)
    PostCommentInfoDto addPostComment(PostCommentCreateDto postCommentCreateDto);
    PostCommentInfoDto updatePostComment(PostCommentInfoDto postCommentInfoDto);
    PostCommentInfoDto getPostComment(Long id);
    Page<PostCommentInfoDto> getPostCommentByPostId(Long postId, Pageable pageable);
    Page<PostCommentInfoDto> getPostCommentByMemberId(Long memberId, Pageable pageable);
    void deletePostComment(Long commentId,Long memberId);
}
