package com.dokyun.DKComunity.dto.message;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageReceiveListDto {
    private Long messageId;
    private Long senderId;
    private String senderNickName;
    private Long receiverId;
    private String receiverNickName;
    private String content;
    private boolean isRead;
    private LocalDateTime sendDate;
    private LocalDateTime readDate;

    public MessageReceiveListDto(Long messageId, Long senderId, String senderNickName, Long receiverId, String receiverNickName, String content,
                                 Boolean isRead,LocalDateTime sendDate, LocalDateTime readDate) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.senderNickName = senderNickName;
        this.receiverId = receiverId;
        this.receiverNickName = receiverNickName;
        this.content = content;
        this.isRead = isRead;
        this.sendDate = sendDate;
        this.readDate = readDate;
    }
}
