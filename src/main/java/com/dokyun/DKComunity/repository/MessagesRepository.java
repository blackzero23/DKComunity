package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.Messages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessagesRepository extends JpaRepository<Messages, Long> {
    //받은사람 메세지 리스트
    @Query(value = "select m from Messages m join fetch m.receiverId where m.receiverId = :receiverId",
            countQuery = "select count(m) from Messages m join m.receiverId where m.receiverId = :receiverId")
    Page<Messages> findByReceiverId(Long receiverId, Pageable pageable);
}
