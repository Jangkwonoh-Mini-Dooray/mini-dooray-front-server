package com.nhnacademy.minidooraygateway.account.adaptor;

import com.nhnacademy.minidooraygateway.account.dto.member.GetMemberDto;
import com.nhnacademy.minidooraygateway.account.dto.member.PostMemberDto;
import com.nhnacademy.minidooraygateway.account.dto.member.PutMemberDto;
import com.nhnacademy.minidooraygateway.account.dto.member.RespMemberDto;
import com.nhnacademy.minidooraygateway.account.dto.member.authority.GetMemberAuthorityDto;
import com.nhnacademy.minidooraygateway.account.dto.member.authority.PutMemberAuthorityDto;
import com.nhnacademy.minidooraygateway.account.dto.member.status.PutMemberStatusDto;
import com.nhnacademy.minidooraygateway.config.UrlProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountAdaptor {
    private final RestTemplate restTemplate;
    private final UrlProperties urlProperties;
    private final PasswordEncoder passwordEncoder;

    public GetMemberDto getMember(String memberId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<GetMemberDto> exchange =
                restTemplate.exchange(urlProperties.getAccountServerUrl() + "/members/" + memberId,
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        return exchange.getBody();
    }

    public RespMemberDto createMember(PostMemberDto postMemberDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        postMemberDto.setPassword(passwordEncoder.encode(postMemberDto.getPassword()));
        HttpEntity<PostMemberDto> requestEntity = new HttpEntity<>(postMemberDto, httpHeaders);

        ResponseEntity<RespMemberDto> exchange =
                restTemplate.exchange(urlProperties.getAccountServerUrl() + "/members",
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        return exchange.getBody();
    }


    public RespMemberDto updateMember(String memberId, PutMemberDto putMemberDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        putMemberDto.setPassword(passwordEncoder.encode(putMemberDto.getPassword()));
        HttpEntity<PutMemberDto> requestEntity = new HttpEntity<>(putMemberDto, httpHeaders);

        ResponseEntity<RespMemberDto> exchange =
                restTemplate.exchange(urlProperties.getAccountServerUrl() + "/members/" + memberId,
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        return exchange.getBody();
    }

    public void deleteMember(String memberId) {
        restTemplate.delete(urlProperties.getAccountServerUrl() + "/members/" + memberId);
    }

    public void updateMemberAuthority(String memberId, PutMemberAuthorityDto putMemberAuthorityDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<PutMemberAuthorityDto> requestEntity = new HttpEntity<>(putMemberAuthorityDto, httpHeaders);

        restTemplate.exchange(urlProperties.getAccountServerUrl() + "/members/" + memberId + "/authority",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Void>() {
                });
    }

    public void updateMemberStatus(String memberId, PutMemberStatusDto putMemberStatusDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<PutMemberStatusDto> requestEntity = new HttpEntity<>(putMemberStatusDto, httpHeaders);

        restTemplate.exchange(urlProperties.getAccountServerUrl() + "/members/" + memberId + "/status",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<Void>() {
                });
    }

}
