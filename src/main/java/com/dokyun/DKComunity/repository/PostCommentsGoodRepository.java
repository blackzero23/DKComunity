package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.PostCommentsGood;
import org.hibernate.sql.ordering.antlr.ColumnMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostCommentsGoodRepository extends JpaRepository<PostCommentsGood,Long> {

    @Query("select p from PostCommentsGood p join fetch p.member m join fetch p.postComments pc where m.id = :memberId")
    Page<PostCommentsGood> findByMemberId(Long memberId, Pageable pageable);
}
