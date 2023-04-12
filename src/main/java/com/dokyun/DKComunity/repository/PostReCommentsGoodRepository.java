package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.PostReCommentsGood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostReCommentsGoodRepository extends JpaRepository<PostReCommentsGood,Long> {

    @Query("select p from PostReCommentsGood p join fetch p.member m join fetch p.postReComments prc where m.id = :memberId")
    Page<PostReCommentsGood> findByMemberId(Long memberId, Pageable pageable);
}
