package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.dto.MemberConditionDto;
import com.dokyun.DKComunity.dto.MemberInfoDto;
import com.dokyun.DKComunity.dto.MemberSignupDto;
import com.dokyun.DKComunity.dto.MemberUpdateDto;
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
