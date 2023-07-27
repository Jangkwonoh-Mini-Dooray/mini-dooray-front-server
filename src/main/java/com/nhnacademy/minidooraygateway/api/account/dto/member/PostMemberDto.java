package com.nhnacademy.minidooraygateway.api.account.dto.member;


import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PostMemberDto {
    private String memberId;
    private String password;
    private String email;
    private String name;

}