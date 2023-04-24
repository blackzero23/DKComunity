package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.PostReCommentsGood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostReCommentsGoodRepository extends JpaRepository<PostReCommentsGood,Long> {

    //TODO : 꼮 아래 처럼 fetch join 으로 다바꿔야 됨 paging 하려면 아래와 같이 countQuery를 같이 사용해야됨.
    // 아니면 dto처리도 쉬운 queryDsl로  시도해보는게좋을듯 .
    @Query(value = "select p from PostReCommentsGood p join fetch p.member m join fetch  p.postReComments prc where m.id = :memberId"
    ,countQuery = "select count(p) from PostReCommentsGood p join p.member m join p.postReComments prc where m.id = :memberId")
    Page<PostReCommentsGood> findByMemberId(Long memberId, Pageable pageable);
}
