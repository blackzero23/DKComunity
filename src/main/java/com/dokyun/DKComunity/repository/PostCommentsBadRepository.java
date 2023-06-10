package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.PostCommentsBad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostCommentsBadRepository extends JpaRepository<PostCommentsBad,Long> {
//    @Query("select p from PostCommentsBad p join fetch p.member join fetch  p.postComments where p.member.id = :memberId")
    Page<PostCommentsBad> findByMemberId(@Param("memberId") Long memberId, Pageable pageable);
}
