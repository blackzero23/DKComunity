package com.dokyun.DKComunity.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberSignupDto {
    private String email;
    private String password;
    private String nickName;
}
