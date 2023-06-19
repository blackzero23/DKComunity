package com.dokyun.DKComunity.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDto {
    private String title;
    private String content;
    private Long categoryId;
    private Long memberId;
}
