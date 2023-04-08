package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.post.PostGoodDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostGoodService {
    //추가 삭제 // 회원과 연관된 조회.
    void addGood(PostGoodDto postGoodDto);

    //TODO: 상태 관리로 인한 삭제로 변경해야됨.
    //ex) 관리자에 의해서 삭제된 댓글입니다, 블라인드 처리된 댓글입니다. 사용자에 의한 삭제 입니다.
    void deleteGood(PostGoodDto postGoodDto);
    Page<PostGoodDto> getPostGoodListOfMember(PostGoodDto postGoodDto, Pageable pageable);
}
