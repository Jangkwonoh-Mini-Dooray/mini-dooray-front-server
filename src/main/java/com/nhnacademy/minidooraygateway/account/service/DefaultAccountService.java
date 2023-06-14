package com.nhnacademy.minidooraygateway.account.service;

import com.nhnacademy.minidooraygateway.account.adaptor.AccountAdaptor;
import com.nhnacademy.minidooraygateway.account.dto.member.PostMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultAccountService implements AccountService {
    public final AccountAdaptor accountAdaptor;

    @Override
    public void createMember(PostMemberDto postMemberDto) {
        accountAdaptor.createMember(postMemberDto);
    }
}
