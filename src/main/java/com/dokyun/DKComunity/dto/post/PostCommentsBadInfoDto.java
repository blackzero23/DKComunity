package com.dokyun.DKComunity.dto.post;

import lombok.Data;

@Data
public class PostCommentsBadInfoDto {
    private Long postCommentsBadId;
    private Long memberId;
    private Long postCommentsId;
    //좋아요 누른 댓글 내용.
    private String content;

    public PostCommentsBadInfoDto(Long postCommentsBadId, Long memberId, Long postCommentsId, String content) {
        this.postCommentsBadId = postCommentsBadId;
        this.memberId = memberId;
        this.postCommentsId = postCommentsId;
        this.content = content;
    }
}
