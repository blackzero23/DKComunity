package com.dokyun.DKComunity.dto.post;

import com.dokyun.DKComunity.domain.PostsBad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostBadDto {
    private Long PostBadId;
    private Long postId;
    private Long memberId;

    public PostBadDto of(PostsBad postsBad) {
        return PostBadDto.builder()
                .PostBadId(postsBad.getId())
                .postId(postsBad.getPosts().getId())
                .memberId(postsBad.getMember().getId())
                .build();
    }
}
