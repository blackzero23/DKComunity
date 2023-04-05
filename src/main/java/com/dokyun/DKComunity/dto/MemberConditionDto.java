package com.dokyun.DKComunity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberConditionDto {
    private String email;
    private String nickName;
}
