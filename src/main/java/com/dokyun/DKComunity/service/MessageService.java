package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.message.MessageReceiveDto;
import com.dokyun.DKComunity.dto.message.MessageReceiveInfoDto;
import com.dokyun.DKComunity.dto.message.MessageReceiveListDto;
import com.dokyun.DKComunity.dto.message.MessageSendDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {
    //쪽지 보내기, 받은 쪽지함, 보낸 쪽지함, 받은사람 쪽지 삭제, 보낸사람 쪽지 삭제,
    void sendMessage(MessageSendDto messageSendDto);
    // 받은 쪽지함
    Page<MessageReceiveListDto> receiveMessageList(MessageReceiveDto messageReceiveDto, Pageable pageable);
    //받은 쪽지 확인.
    MessageReceiveInfoDto receiveMessage(MessageReceiveDto messageReceiveDto);
    //받은 쪽지 삭제
    void deleteReceiveMessage(MessageReceiveDto messageReceiveDto);
    //TODO: 선택된 받은 쪽지 리스트 삭제

}
