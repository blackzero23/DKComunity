package com.dokyun.DKComunity.service;

import com.dokyun.DKComunity.dto.member.MemberConditionDto;
import com.dokyun.DKComunity.dto.member.MemberInfoDto;
import com.dokyun.DKComunity.dto.member.MemberSignupDto;
import com.dokyun.DKComunity.dto.member.MemberUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {

    //회원 가입
    void signup(MemberSignupDto memberSignupDto);
    //회원 수정
    MemberInfoDto memberUpdate(MemberUpdateDto memberUpdateDto);
    //회원 리스트 조회
    Page<MemberInfoDto> getMemberInfoList(MemberConditionDto memberConditionDto, Pageable pageable);

}
