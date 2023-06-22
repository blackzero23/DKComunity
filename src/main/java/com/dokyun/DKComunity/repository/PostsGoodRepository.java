package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.Posts;
import com.dokyun.DKComunity.domain.PostsGood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsGoodRepository extends JpaRepository<PostsGood, Long> {
    @Query("select pg from PostsGood pg join  pg.member join pg.posts where pg.member.id = :memberId")
    Page<PostsGood> findByMember(Member member, Pageable pageable);

    //현재 게시판에 대한 좋아요 개수.
    Long countByPosts(Posts posts);
}
