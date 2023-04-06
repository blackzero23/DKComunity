package com.dokyun.DKComunity.dto.post;

import com.dokyun.DKComunity.domain.PostsCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCateInfoDto {
    private Long id;
    private String title;

    public PostCateInfoDto(PostsCategory postsCategory) {
        this.id = postsCategory.getId();
        this.title = postsCategory.getTitle();
    }
}
