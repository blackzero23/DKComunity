package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.PostsBad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostBadRepository extends JpaRepository<PostsBad, Long> {
    Optional<PostsBad> findByMemberId(Long memberId);

    Optional<PostsBad> findByPostsId(Long postsId);

    @Query(value = "select pb from PostsBad pb join fetch pb.member join fetch pb.posts where pb.member.id = :memberId",
            countQuery = "select count(pb) from PostsBad pb join pb.member join pb.posts where pb.member.id = :memberId")
    Page<PostsBad> findByMemberId(Long memberId, Pageable pageable);
}
