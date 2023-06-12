package com.nhnacademy.minidooraygateway.service;

import com.nhnacademy.minidooraygateway.config.UrlProperties;
import com.nhnacademy.minidooraygateway.domain.OAuth2GitEmail;
import com.nhnacademy.minidooraygateway.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UrlProperties urlProperties;
    private final RestTemplate restTemplate;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        HttpHeaders header = new HttpHeaders();
        header.setAccept(List.of(MediaType.valueOf("application/vnd.github+json")));
        header.setBearerAuth(userRequest.getAccessToken().getTokenValue());
        header.set("X-GitHub-Api-Version", "2022-11-28");
        HttpEntity<List<OAuth2GitEmail>> requestEntity = new HttpEntity<>(header);

        ResponseEntity<List<OAuth2GitEmail>> response =
                restTemplate.exchange("https://api.github.com/user/emails",
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        List<OAuth2GitEmail> body = response.getBody();
        String email = getPrimaryEmail(body);

        log.error("email : {}",email);


        return null;
    }


    private static String getPrimaryEmail(List<OAuth2GitEmail> response) {
        return response.stream()
                .filter(OAuth2GitEmail::getPrimary)
                .findAny()
                .orElseThrow()
                .getEmail();
    }
}
