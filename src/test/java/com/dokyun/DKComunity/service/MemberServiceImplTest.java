package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원 가입 테스트")
    void givenMember_whenSave_thenSuccess() {
        //given
        Member member = Member.createMember("test", "test", "test@name.com");
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Assertions.assertThat(savedMember.getId()).isEqualTo(member.getId());
    }

    @Test
    @DisplayName("회원 수정 테스트")
    void givenMember_whenUpdate_thenSuccess() {
        //given
        Member member = Member.createMember("test", "test", "test@Name.com");
        Member savedMember = memberRepository.save(member);

        //when
        savedMember.setNickName("test2");
        memberRepository.save(savedMember);
        //then
        Assertions.assertThat(savedMember.getNickName()).isEqualTo("test2");
    }

    @Test
    @DisplayName("회원 삭제 테스트")
    void givenMember_whenDelete_thenSuccess() {
        //given
        Member member = Member.createMember("test", "test", "test@gmail.com");
        Member savedMember = memberRepository.save(member);

        //when
        memberRepository.delete(savedMember);
        //then
        List<Member> memberList = memberRepository.findAll();
        Assertions.assertThat(memberList.size()).isEqualTo(0);

    }
}