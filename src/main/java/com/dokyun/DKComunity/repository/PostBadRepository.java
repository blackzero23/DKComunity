package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.PostsBad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostBadRepository extends JpaRepository<PostsBad, Long> {
    Optional<PostsBad> findByMemberId(Long memberId);

    Optional<PostsBad> findByPostsId(Long postsId);

    Page<PostsBad> findByMember(Long memberId, Pageable pageable);
}
