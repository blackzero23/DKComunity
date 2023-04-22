package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.PostComments;
import com.dokyun.DKComunity.domain.PostCommentsGood;
import com.dokyun.DKComunity.dto.post.PostCommentsGoodInfoDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.PostCommentsGoodRepository;
import com.dokyun.DKComunity.repository.PostCommentsRepository;
import com.dokyun.DKComunity.service.PostCommentsGoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostCommentsGoodServiceImpl implements PostCommentsGoodService {
    private final MemberRepository memberRepository;
    private final PostCommentsRepository postCommentsRepository;
    private final PostCommentsGoodRepository postCommentsGoodRepository;
    @Override
    public void addPostCommentsGood(Long memberId, Long postCommentsId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        PostComments postComments = postCommentsRepository.findById(postCommentsId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));

        PostCommentsGood postCommentsGood = new PostCommentsGood(member, postComments);

        postCommentsGoodRepository.save(postCommentsGood);

    }

    @Override
    public void deletePostCommentsGood(Long memberId, Long postCommentsGoodId) {
        memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        postCommentsGoodRepository.findById(postCommentsGoodId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 좋아요입니다."));
        postCommentsGoodRepository.deleteById(postCommentsGoodId);
    }

    @Override
    public Page<PostCommentsGoodInfoDto> getPostCommentsGoodListByMember(Long memberId, Long postCommentsGoodId, Pageable pageable) {
        memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        postCommentsGoodRepository.findById(postCommentsGoodId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 좋아요입니다."));

        //TODO: N+1 해결 좋아요 1건당 해당 댓글내용 조회 하기때문에 한번에 조회 테스트로 확인해보기.
        //List 처리가 자동으로 되던가 확인.
        return postCommentsGoodRepository.findByMember(memberId, pageable).map(postCommentsGood ->
                new PostCommentsGoodInfoDto(postCommentsGood.getId(),postCommentsGood.getMember().getId()
                  ,postCommentsGood.getPostComments().getId(), postCommentsGood.getPostComments().getContent()));
    }
}
