package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.PostsCategory;
import com.dokyun.DKComunity.dto.post.PostCateCreateDto;
import com.dokyun.DKComunity.dto.post.PostCateInfoDto;
import com.dokyun.DKComunity.repository.PostCategoryRepository;
import com.dokyun.DKComunity.service.PostCategoryService;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostCategoryServiceImpl implements PostCategoryService {

    private final PostCategoryRepository postCategoryRepository;
    @Override
    public void createPostCategory(PostCateCreateDto postCateCreateDto) {
       validateDuplicatePostCategory(postCateCreateDto.getTitle());
        PostsCategory postsCategory = PostsCategory.builder().title(postCateCreateDto.getTitle()).build();
        postCategoryRepository.save(postsCategory);
    }

    //TODO : HIT 동시성문제랑 같이 구현하기.
    @Override
    public PostCateInfoDto getPostCategory(Long id) {
        PostsCategory postsCategory = postCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
        return new PostCateInfoDto(postsCategory);
    }

    //TODO: Page 를 서비스단에서 처리 인지 컨트롤단인지.
    @Override
    public Page<PostCateInfoDto> getPostCategoryList(Pageable pageable) {
        return postCategoryRepository.findAll(pageable).map(PostCateInfoDto::new);
    }

    @Override
    public PostCateInfoDto updatePostCategory(PostCateInfoDto postCateInfoDto) {
        PostsCategory postsCategory = validateExistsPostCategory(postCateInfoDto.getId());
        postsCategory.setTitle(postCateInfoDto.getTitle());
        postCategoryRepository.save(postsCategory);
        return new PostCateInfoDto(postsCategory);
    }

    @Override
    public void deletePostCategory(Long id) {
        PostsCategory postsCategory = validateExistsPostCategory(id);
        postCategoryRepository.delete(postsCategory);
    }

    PostsCategory validateExistsPostCategory(Long id){
        return postCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

    void validateDuplicatePostCategory(String title){
//    TODO: 카테고리 중복확인 Exception 부분 다시 만들기
        Optional<PostsCategory> optionalPostsCategory = postCategoryRepository.findByTitle(title);
        PostsCategory postsCategory = null;
        try{
            if(optionalPostsCategory.isPresent())
                throw new DuplicateRequestException();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}