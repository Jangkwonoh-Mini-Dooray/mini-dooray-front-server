package com.nhnacademy.minidooraygateway.api.account.service;

import com.nhnacademy.minidooraygateway.api.account.dto.member.GetMemberDto;
import com.nhnacademy.minidooraygateway.api.account.dto.member.PostMemberDto;

import java.util.List;

public interface AccountService {
    void createMember(PostMemberDto postMemberDto);
    List<GetMemberDto> getMembers();
}
