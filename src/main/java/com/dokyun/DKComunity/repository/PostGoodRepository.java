package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsGood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostGoodRepository extends JpaRepository<PostsGood, Long> {
    @Query("select pg from PostsGood pg join  pg.member join pg.posts where pg.member.id = :memberId")
    Page<PostsGood> findByMember(Member member, Pageable pageable);
}
