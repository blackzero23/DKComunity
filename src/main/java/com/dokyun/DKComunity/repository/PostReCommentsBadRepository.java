package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.PostReCommentsBad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostReCommentsBadRepository extends JpaRepository<PostReCommentsBad, Long> {
//    @Query("select p from PostReCommentsBad p join fetch p.member join fetch p.postReComments where p.member.id = :memberId")
    Page<PostReCommentsBad> findByMemberId(@Param("memberId") Long memberId, Pageable pageable);
}
