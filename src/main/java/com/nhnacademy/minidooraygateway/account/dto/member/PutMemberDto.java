package com.nhnacademy.minidooraygateway.account.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutMemberDto {
    private String password;
    private String email;
    private String name;
}
