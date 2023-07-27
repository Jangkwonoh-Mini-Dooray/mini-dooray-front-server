package com.nhnacademy.minidooraygateway.service;

import com.nhnacademy.minidooraygateway.api.account.adaptor.AccountAdaptor;
import com.nhnacademy.minidooraygateway.api.account.dto.member.GetMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AccountAdaptor accountAdaptor;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        GetMemberDto getMemberDto = accountAdaptor.getMember(memberId);
        return new User(getMemberDto.getMemberId(), getMemberDto.getPassword(),
            Collections.singleton(new SimpleGrantedAuthority(getMemberDto.getMemberAuthorityStatus())));
    }
}
