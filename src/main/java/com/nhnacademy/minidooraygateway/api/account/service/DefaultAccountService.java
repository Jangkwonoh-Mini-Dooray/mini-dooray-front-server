package com.nhnacademy.minidooraygateway.api.account.service;

import com.nhnacademy.minidooraygateway.api.account.adaptor.AccountAdaptor;
import com.nhnacademy.minidooraygateway.api.account.dto.member.GetMemberDto;
import com.nhnacademy.minidooraygateway.api.account.dto.member.PostMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultAccountService implements AccountService {
    public final AccountAdaptor accountAdaptor;

    @Override
    public void createMember(PostMemberDto postMemberDto) {
        accountAdaptor.createMember(postMemberDto);
    }

    @Override
    public List<GetMemberDto> getMembers() {
        return accountAdaptor.getMembers();
    }
}
