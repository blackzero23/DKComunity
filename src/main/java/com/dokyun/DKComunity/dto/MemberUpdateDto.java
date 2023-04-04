package com.dokyun.DKComunity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberUpdateDto {
    private Long id;
    private String email;
    private String password;
    private String nickName;
}