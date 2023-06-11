package com.nhnacademy.minidooraygateway.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String memberId;
    private String memberAuthorityStatus;
    private String password;
    private String email;
    private String name;
}
