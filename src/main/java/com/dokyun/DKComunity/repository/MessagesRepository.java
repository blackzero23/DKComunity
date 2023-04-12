package com.dokyun.DKComunity.repository;

import com.dokyun.DKComunity.domain.Messages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Messages, Long> {
    //받은사람 메세지 리스트
    Page<Messages> findByReceiverId(Long receiverId, Pageable pageable);
}
