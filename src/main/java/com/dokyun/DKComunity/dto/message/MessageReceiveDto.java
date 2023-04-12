package com.dokyun.DKComunity.dto.message;

import lombok.Data;

@Data
public class MessageReceiveDto {
    private Long messageId;
    private Long receiverMemberId;

    public MessageReceiveDto(Long messageId, Long receiverMemberId, String sendDate, String readDate) {
        this.messageId = messageId;
        this.receiverMemberId = receiverMemberId;
    }
}
