package com.nhnacademy.minidooraygateway.account.service;

import com.nhnacademy.minidooraygateway.account.dto.member.PostMemberDto;

public interface AccountService {
    void createMember(PostMemberDto postMemberDto);
}
