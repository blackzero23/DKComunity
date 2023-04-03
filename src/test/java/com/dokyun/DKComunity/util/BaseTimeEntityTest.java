package com.dokyun.DKComunity.util;

import com.dokyun.DKComunity.domain.Members;
import com.dokyun.DKComunity.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BaseTimeEntityTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("BaseTimeEntity_등록시 생성자_수정자_생성시간_수정시간_자동입력")
    void BaseTimeEntity_등록시_생성자_수정자_생성시간_수정시간_자동입력() {
        //given
        Members member = new Members();
        member.setNickName("test");
        member.setEmail("test@email");
        member.setPassword("test");
        member.setPassword("test");
        //when
        memberRepository.save(member);
        //then
        Members findMember = memberRepository.findById(member.getId()).get();
        System.out.println("findMember.getCreatedDate() = " + findMember.getCreateAt());
        System.out.println("findMember.getCreatedDate() = " + findMember.getCreateBy());
    }

}