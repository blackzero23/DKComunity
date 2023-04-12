package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.PostComments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentsRepository extends JpaRepository<PostComments, Long>{

    //TODO: queryDSL로 한번에 변환되도록 변환.
    Page<PostComments> findByPostsId(Long postId, Pageable pageable);

    Page<PostComments> findByMemberId(Long memberId, Pageable pageable);
}
