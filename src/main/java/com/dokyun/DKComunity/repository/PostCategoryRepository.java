package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.PostsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostCategoryRepository extends JpaRepository<PostsCategory, Long> {

    Optional<PostsCategory> findByTitle(String title);

}
