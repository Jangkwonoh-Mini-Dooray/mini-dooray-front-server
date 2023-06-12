package com.nhnacademy.minidooraygateway.account.adaptor;

import com.nhnacademy.minidooraygateway.account.dto.member.GetMemberDto;
import com.nhnacademy.minidooraygateway.account.dto.member.PostMemberDto;
import com.nhnacademy.minidooraygateway.account.dto.member.PutMemberDto;
import com.nhnacademy.minidooraygateway.account.dto.member.RespMemberDto;
import com.nhnacademy.minidooraygateway.account.dto.member.authority.GetMemberAuthorityDto;
import com.nhnacademy.minidooraygateway.account.dto.member.authority.PutMemberAuthorityDto;
import com.nhnacademy.minidooraygateway.account.dto.member.status.GetMemberStatusDto;
import com.nhnacademy.minidooraygateway.account.dto.member.status.PutMemberStatusDto;
import com.nhnacademy.minidooraygateway.config.UrlProperties;
import com.nhnacademy.minidooraygateway.util.DefaultHttpHeader;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountAdaptor {
    private final RestTemplate restTemplate;
    private final UrlProperties urlProperties;
    private final PasswordEncoder passwordEncoder;

    public GetMemberDto getMember(String memberId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<GetMemberDto> exchange =
                restTemplate.exchange(urlProperties.getMember(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, memberId);
        return exchange.getBody();
    }

    public GetMemberDto getMemberByEmail(String email) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<GetMemberDto> exchange =
                restTemplate.exchange(urlProperties.getMemberByEmail(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, email);
        return exchange.getBody();
    }

    public RespMemberDto createMember(PostMemberDto postMemberDto) {
        postMemberDto.setPassword(passwordEncoder.encode(postMemberDto.getPassword()));
        HttpEntity<PostMemberDto> requestEntity = new HttpEntity<>(postMemberDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespMemberDto> exchange =
                restTemplate.exchange(urlProperties.createMember(),
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        return exchange.getBody();
    }


    public RespMemberDto updateMember(String memberId, PutMemberDto putMemberDto) {
        putMemberDto.setPassword(passwordEncoder.encode(putMemberDto.getPassword()));
        HttpEntity<PutMemberDto> requestEntity = new HttpEntity<>(putMemberDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespMemberDto> exchange =
                restTemplate.exchange(urlProperties.updateMember(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, memberId);
        return exchange.getBody();
    }

    public void deleteMember(String memberId) {
        String url = UriComponentsBuilder.fromUriString(urlProperties.deleteMember())
                .buildAndExpand(memberId)
                .toUriString();
        restTemplate.delete(url);
    }

    public GetMemberAuthorityDto getMemberAuthority(String memberId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<GetMemberAuthorityDto> exchange =
                restTemplate.exchange(urlProperties.getMemberAuthority(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, memberId);
        return exchange.getBody();
    }

    public void updateMemberAuthority(String memberId, PutMemberAuthorityDto putMemberAuthorityDto) {
        HttpEntity<PutMemberAuthorityDto> requestEntity = new HttpEntity<>(putMemberAuthorityDto, DefaultHttpHeader.getHeader());

        restTemplate.exchange(urlProperties.updateMemberAuthority(),
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Void>() {
                }, memberId);
    }

    public GetMemberStatusDto getMemberStatus(String memberId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<GetMemberStatusDto> exchange =
                restTemplate.exchange(urlProperties.getMemberStatus(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<GetMemberStatusDto>() {
                        }, memberId);
        return exchange.getBody();
    }

    public void updateMemberStatus(String memberId, PutMemberStatusDto putMemberStatusDto) {
        HttpEntity<PutMemberStatusDto> requestEntity = new HttpEntity<>(putMemberStatusDto, DefaultHttpHeader.getHeader());

        restTemplate.exchange(urlProperties.updateMemberStatus(),
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Void>() {
                }, memberId);
    }
}
