package com.dokyun.DKComunity.dto.post;

import lombok.Data;

@Data

public class PostReCommentCreateDto {

    private Long postCommentId;
    private Long memberId;
    private String content;

    public PostReCommentCreateDto( Long postCommentId, Long memberId, String content) {
        this.postCommentId = postCommentId;
        this.memberId = memberId;
        this.content = content;
    }
}
