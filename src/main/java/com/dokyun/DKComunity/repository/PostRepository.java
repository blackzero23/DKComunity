package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {
}
