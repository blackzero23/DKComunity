package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.post.PostReCommentsGoodInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostReCommentsGoodService {
    //좋아요 , 삭제, 조회
    void save(Long postReCommentId, Long memberId);
    void delete(Long postReCommentId, Long memberId);
    Page<PostReCommentsGoodInfoDto> getPostReCommentsGoodListByMemberId(Long memberId, Pageable pageable);
}
