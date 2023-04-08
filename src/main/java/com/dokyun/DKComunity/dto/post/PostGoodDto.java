package com.dokyun.DKComunity.dto.post;

import com.dokyun.DKComunity.domain.PostsGood;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostGoodDto {
    private Long postGoodId;
    private Long postId;
    private Long memberId;

    public static PostGoodDto of(PostsGood postsGood) {
        return PostGoodDto.builder()
                .postGoodId(postsGood.getId())
                .postId(postsGood.getPosts().getId())
                .memberId(postsGood.getMember().getId())
                .build();
    }
}
