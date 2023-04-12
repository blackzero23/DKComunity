package com.dokyun.DKComunity.dto.message;

import lombok.Data;

@Data
public class MessageSendDto {
    private Long senderId;
    private Long receiverId;
    private String content;
}
