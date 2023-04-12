package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.post.PostCommentsBadInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostCommentsBadService {
    //추가 삭제
    void addPostBad(Long postId, Long memberId);
    void deletePostBad(Long postBadId, Long memberId);
    Page<PostCommentsBadInfoDto> getPostGoodListOfMember(Long memberId, Pageable pageable);
}
