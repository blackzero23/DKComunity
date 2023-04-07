package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.post.PostCateCreateDto;
import com.dokyun.DKComunity.dto.post.PostCateInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostCategoryService {
    void createPostCategory(PostCateCreateDto title);
    PostCateInfoDto getPostCategory(Long id);
    Page<PostCateInfoDto> getPostCategoryList(Pageable pageable);
    PostCateInfoDto updatePostCategory(PostCateInfoDto postCateInfoDto);
    void deletePostCategory(Long id);

}
