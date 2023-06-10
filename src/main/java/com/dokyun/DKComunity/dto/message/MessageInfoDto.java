package com.dokyun.DKComunity.dto.message;

import lombok.Data;

@Data
public class MessageInfoDto {
    private Long messageId;
    private Long senderMemberId;
    private Long receiverMemberId;
    private String content;
    private String sendDate;
    private String readDate;

    public MessageInfoDto(Long messageId, Long senderMemberId, Long receiverMemberId, String content, String sendDate, String readDate) {
        this.messageId = messageId;
        this.senderMemberId = senderMemberId;
        this.receiverMemberId = receiverMemberId;
        this.content = content;
        this.sendDate = sendDate;
        this.readDate = readDate;
    }
}
