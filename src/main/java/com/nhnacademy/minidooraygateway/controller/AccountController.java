package com.nhnacademy.minidooraygateway.controller;

import com.nhnacademy.minidooraygateway.account.adaptor.AccountAdaptor;
import com.nhnacademy.minidooraygateway.account.dto.member.PostMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountAdaptor accountAdaptor;

    @GetMapping("/sign-up")
    public String signUpForm() {
        return "account/signup";
    }

    @PostMapping("/sign-up")
    public String doSignUp(@ModelAttribute @Valid PostMemberDto postMemberDto) {
        accountAdaptor.createMember(postMemberDto);
        return "account/test";
    }

    // 회원가입, 로그인 성공 확인용 test
    @GetMapping("/test")
    public String test() {
        return "account/test";
    }
}
