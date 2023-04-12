package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.post.PostReCommentsBadInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostReCommentsBadService {

    //싫어요 추가, 삭제, 맴버기준 싫어요 댓글 리스트.
    void addPostReCommentsBad(Long postReCommentsId, Long memberId);
    void deletePostReCommentsBad(Long postReCommentsBadId, Long memberId);
    Page<PostReCommentsBadInfoDto> getPostReCommentsBadListByMember(Long memberId, Pageable pageable);
}
