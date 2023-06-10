package com.dokyun.DKComunity.domain;

import com.dokyun.DKComunity.util.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "messages")
@NoArgsConstructor
//메세지는 연관관계를 짓지않고 단순히 보낸사람, 받는사람, 내용, 읽었는지 여부만 저장한다.
public class Messages extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;
    private Long senderId;
    private String SendNickName;
    private Long receiverId;
    private String receiverNickName;
    private String content;
    private boolean isRead;
    private LocalDateTime readDate;

    public Messages(Long senderId, Long receiverId, String content) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.isRead = false;
    }

    public void updateRead(){
        this.isRead = true;
        this.readDate = LocalDateTime.now();
    }
}
