package com.dokyun.DKComunity.dto.member;

import com.dokyun.DKComunity.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberInfoDto {
    private Long id;
    private String email;
    private String nickName;


    public static MemberInfoDto toDto(Member member){
        return MemberInfoDto.builder()
                .id(member.getId())
                .email(member.getEmail())
                .nickName(member.getNickName())
                .build();
    }
}
