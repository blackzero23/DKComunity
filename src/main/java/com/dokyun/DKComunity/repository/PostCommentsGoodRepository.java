package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.PostCommentsGood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostCommentsGoodRepository extends JpaRepository<PostCommentsGood,Long> {

    @Query("select p from PostCommentsGood p join p.member m join p.postComments pc where m.id = :memberId")
    Page<PostCommentsGood> findByMember(@Param("memberId") Long memberId, Pageable pageable);
}
