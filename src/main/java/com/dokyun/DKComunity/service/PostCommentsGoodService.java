package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.post.PostCommentsGoodInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostCommentsGoodService {
    //댓글 좋아요, 좋아요 취소 조회ofMemberId
    void addPostCommentsGood(Long memberId, Long postCommentsId);

    void deletePostCommentsGood(Long memberId, Long postCommentsId);

    Page<PostCommentsGoodInfoDto> getPostCommentsGoodListByMember(Long memberId, Long postCommentsId, Pageable pageable);
}
