package com.dokyun.DKComunity.dto.post;

import lombok.Data;

@Data
public class PostReCommentsGoodInfoDto {
    private Long postReCommentsGoodId;
    private Long memberId;
    private Long postReCommentsId;
    //좋아요 누른 댓글 내용.
    private String content;

    public PostReCommentsGoodInfoDto(Long postReCommentsGoodId, Long memberId, Long postReCommentsId, String content) {
        this.postReCommentsGoodId = postReCommentsGoodId;
        this.memberId = memberId;
        this.postReCommentsId = postReCommentsId;
        this.content = content;
    }
}
