package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.Messages;
import com.dokyun.DKComunity.domain.PostsBad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessagesRepository extends JpaRepository<Messages, Long> {

//    @Query(value = "select pb from PostsBad pb join fetch pb.member join fetch pb.posts where pb.member.id = :memberId",
//            countQuery = "select count(pb) from PostsBad pb join pb.member join pb.posts where pb.member.id = :memberId")
//    Page<PostsBad> findByMemberId(Long memberId, Pageable pageable);
    //받은사람 메세지 리스트
    @Query(value = "select m from Messages m where m.receiverId =:receiverId ",
            countQuery = "select count(m) from Messages m where m.receiverId =:receiverId")
    Page<Messages> findByReceiverId(Long receiverId, Pageable pageable);
}
