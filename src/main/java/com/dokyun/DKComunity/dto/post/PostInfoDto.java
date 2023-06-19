package com.dokyun.DKComunity.dto.post;

import com.dokyun.DKComunity.domain.Posts;
import lombok.*;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class PostInfoDto  {
    private Long id;
    private String title;
    private String content;
    private Long hit;
    private String createBy;
    private String modifiedBy;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long postCateId;


    public static PostInfoDto of(Posts post){
        PostInfoDto postInfoDto = new PostInfoDto();
        postInfoDto.setId(post.getId());
        postInfoDto.setTitle(post.getTitle());
        postInfoDto.setContent(post.getContent());
        postInfoDto.setHit(post.getHit());
        postInfoDto.setCreateBy(post.getCreateBy());
        postInfoDto.setModifiedBy(post.getCreateBy());
        postInfoDto.setCreatedAt(post.getCreateAt());
        postInfoDto.setModifiedAt(post.getModifiedAt());
        postInfoDto.setPostCateId(post.getPostsCategory().getId());
        return postInfoDto;
    }
}
