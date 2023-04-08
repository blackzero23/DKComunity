package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.post.PostBadDto;
import com.dokyun.DKComunity.dto.post.PostGoodDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostBadService {
    //추가 삭제
    void addPostBad(Long postId, Long memberId);
    void deletePostBad(PostBadDto postBadDto);

    Page<PostBadDto> getPostGoodListOfMember(PostBadDto PostBadDto, Pageable pageable);


}
