package com.dokyun.DKComunity.dto.post;

import lombok.Data;

@Data
public class PostCommentsGoodInfoDto {
    private Long postCommentsGoodId;
    private Long memberId;
    private Long postCommentsId;
    //좋아요 누른 댓글 내용.
    private String content;

    public PostCommentsGoodInfoDto(Long postCommentsGoodId, Long memberId, Long postCommentsId, String content) {
        this.postCommentsGoodId = postCommentsGoodId;
        this.memberId = memberId;
        this.postCommentsId = postCommentsId;
        this.content = content;
    }
}
