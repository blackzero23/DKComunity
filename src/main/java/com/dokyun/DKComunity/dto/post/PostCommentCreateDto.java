package com.dokyun.DKComunity.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PostCommentCreateDto {
    private Long postId;
    private Long postCommentId;
    private Long memberId;
    private String content;
}
