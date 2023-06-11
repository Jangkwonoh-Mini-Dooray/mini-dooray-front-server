package com.nhnacademy.minidooraygateway.account.adaptor;

import com.nhnacademy.minidooraygateway.account.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountAdaptor {
    private final RestTemplate restTemplate;

    @Transactional(readOnly = true)
    public Member getMember(String memberId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Member> exchange =
                restTemplate.exchange("http://localhost:9090/" + "{member-id}",
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<Member>() {
                        }, memberId);
        return exchange.getBody();
    }
}
