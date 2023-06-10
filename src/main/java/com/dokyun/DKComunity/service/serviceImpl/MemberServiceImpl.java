package com.dokyun.DKComunity.service.serviceImpl;

import com.dokyun.DKComunity.domain.Member;
import com.dokyun.DKComunity.dto.member.MemberConditionDto;
import com.dokyun.DKComunity.dto.member.MemberInfoDto;
import com.dokyun.DKComunity.dto.member.MemberSignupDto;
import com.dokyun.DKComunity.dto.member.MemberUpdateDto;
import com.dokyun.DKComunity.repository.MemberRepository;
import com.dokyun.DKComunity.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public void signup(MemberSignupDto memberSignupDto) {
        Member member = Member.createMember(memberSignupDto.getEmail(),
                passwordEncoder.encode(memberSignupDto.getPassword()), memberSignupDto.getNickName());
        Member findMember = validateDuplicateMember(member);
        memberRepository.save(member);
    }

    @Override
    public MemberInfoDto memberUpdate(MemberUpdateDto memberUpdateDto) {
        Member member = checkExistMember(memberUpdateDto.getId());

        member.setEmail(memberUpdateDto.getEmail());
        member.setPassword(passwordEncoder.encode(memberUpdateDto.getPassword()));
        member.setNickName(memberUpdateDto.getNickName());

        Member updatedMember = memberRepository.save(member);

        return MemberInfoDto.toDto(updatedMember);
    }

    //TODO: QueryDSL로 조건절로. 이메일 닉네임.
    @Override
    public Page<MemberInfoDto> getMemberInfoList(MemberConditionDto memberConditionDto, Pageable pageable) {
        return null;
    }

    private Member checkExistMember(Long id){
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
    private Member validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null){
            throw new IllegalArgumentException("이미 가입된 이메일 입니다.");
        }
        return member;
    }
}

