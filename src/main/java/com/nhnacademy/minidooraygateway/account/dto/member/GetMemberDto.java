package com.nhnacademy.minidooraygateway.account.dto.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetMemberDto {
    private String memberId;
    private String memberAuthorityStatus;
    private String password;
    private String email;
    private String name;
}
