package com.dokyun.DKComunity.dto.post;

import lombok.Data;

@Data
public class PostReCommentsBadInfoDto {
    private Long postReCommentsId;
    private Long postReCommentsBadId;
    private String content;

    public PostReCommentsBadInfoDto(Long postReCommentsId, Long postReCommentsBadId, String content) {
        this.postReCommentsId = postReCommentsId;
        this.postReCommentsBadId = postReCommentsBadId;
        this.content = content;
    }

}
