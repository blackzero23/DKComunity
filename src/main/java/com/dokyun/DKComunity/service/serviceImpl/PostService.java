package com.dokyun.DKComunity.service.serviceImpl;


import com.dokyun.DKComunity.dto.post.PostCreateDto;
import com.dokyun.DKComunity.dto.post.PostInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    PostInfoDto createPost(PostCreateDto postCreateDto);

    PostInfoDto getPost(Long id);

    Page<PostInfoDto> getPostList(Pageable pageable);
    PostInfoDto updatePost(PostInfoDto postInfoDto);

    void deletePost(Long id);

}
