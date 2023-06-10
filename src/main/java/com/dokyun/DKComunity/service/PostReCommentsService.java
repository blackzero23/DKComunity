package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.post.PostReCommentCreateDto;
import com.dokyun.DKComunity.dto.post.PostReCommentDto;
import org.springframework.data.domain.Page;

public interface PostReCommentsService {
    //추가 수정 삭제 댓글에 대한 대댓글조회
    void addReComment(PostReCommentCreateDto postReCommentCreateDto);

    void updateReComment(PostReCommentDto postReCommentDto);

    //TODO: 상태 관리로 인한 삭제로 변경해야됨.
    void deleteReComment(PostReCommentDto postReCommentDto);

    Page<PostReCommentDto> getReCommentListOfComment(PostReCommentDto postReCommentDto);

}
