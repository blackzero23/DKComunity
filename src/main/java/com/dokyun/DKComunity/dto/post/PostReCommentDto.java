package com.dokyun.DKComunity.dto.post;

import lombok.Data;

@Data
public class PostReCommentDto {
    private Long id;
    private Long postCommentId;
    private Long memberId;
    private String content;

    public PostReCommentDto(Long id, Long postCommentId, Long memberId, String content) {
        this.id = id;
        this.postCommentId = postCommentId;
        this.memberId = memberId;
        this.content = content;
    }
}
