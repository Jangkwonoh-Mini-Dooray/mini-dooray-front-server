package com.nhnacademy.minidooraygateway.account.service;

import com.nhnacademy.minidooraygateway.account.dto.member.GetMemberDto;
import com.nhnacademy.minidooraygateway.account.dto.member.PostMemberDto;

import java.util.List;

public interface AccountService {
    void createMember(PostMemberDto postMemberDto);
    List<GetMemberDto> getMembers();
}
