package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.domain.Messages;
import com.dokyun.DKComunity.dto.message.MessageReceiveDto;
import com.dokyun.DKComunity.dto.message.MessageReceiveInfoDto;
import com.dokyun.DKComunity.dto.message.MessageReceiveListDto;
import com.dokyun.DKComunity.dto.message.MessageSendDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.repository.MessagesRepository;
import com.dokyun.DKComunity.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MessageServiceImpl implements MessageService {
    private final MemberRepository memberRepository;
    private final MessagesRepository messagesRepository;

    @Override
    public void sendMessage(MessageSendDto messageSendDto) {
        //누가 누구에게.
        Member sendMember = memberRepository.findById(messageSendDto.getSenderId()).orElseThrow(() -> new IllegalArgumentException("보내는 사람의 회원은 존재 하지 않습니다."));
        Member reseverMember = memberRepository.findById(messageSendDto.getReceiverId()).orElseThrow(() -> new IllegalArgumentException("받는 사람의 회원은 존재 하지 않습니다."));
        //메세지 내용
        String content = messageSendDto.getContent();
        //메세지 저장
        Messages messages = new Messages(sendMember.getId(), reseverMember.getId(), content);
        messagesRepository.save(messages);
    }

    @Override
    public Page<MessageReceiveListDto> receiveMessageList(MessageReceiveDto messageReceiveDto, Pageable pageable) {
        //나에게 온 메시지 리스트 확인.
        Member member = memberRepository.findById(messageReceiveDto.getReceiverMemberId()).orElseThrow(() -> new IllegalArgumentException("회원이 존재 하지 않습니다."));
        return messagesRepository.findByReceiverId(member.getId(), pageable)
                .map(messages -> new MessageReceiveListDto(messages.getId(), messages.getSenderId(), messages.getSendNickName(),
                        messages.getReceiverId(), messages.getReceiverNickName(), messages.getContent(), messages.isRead(), messages.getCreateAt(), messages.getReadDate()));
    }

    @Override
    public MessageReceiveInfoDto receiveMessage(MessageReceiveDto messageReceiveDto) {
        //멤버 확인후 읽음 확인
        Messages messages = messagesRepository.findById(messageReceiveDto.getMessageId()).orElseThrow(() -> new IllegalArgumentException("메세지는 존재 하지 않습니다."));

        if (!messages.isRead()) {
            messages.updateRead();
        }

        return new MessageReceiveInfoDto(messages.getId(), messages.getSenderId(), messages.getSendNickName(),
                messages.getReceiverId(), messages.getReceiverNickName(), messages.getContent(), messages.getCreateAt(), messages.getReadDate());

    }

    @Override
    public void deleteReceiveMessage(MessageReceiveDto messageReceiveDto) {
        memberRepository.findById(messageReceiveDto.getReceiverMemberId()).orElseThrow(() -> new IllegalArgumentException("회원이 존재 하지 않습니다."));
        messagesRepository.findById(messageReceiveDto.getMessageId()).orElseThrow(() -> new IllegalArgumentException("메세지는 존재 하지 않습니다."));
        messagesRepository.deleteById(messageReceiveDto.getMessageId());
    }

}
