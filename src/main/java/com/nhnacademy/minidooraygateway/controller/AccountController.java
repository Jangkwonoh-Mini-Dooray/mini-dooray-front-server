package com.nhnacademy.minidooraygateway.controller;

import com.nhnacademy.minidooraygateway.account.adaptor.AccountAdaptor;
import com.nhnacademy.minidooraygateway.account.dto.member.PostMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final AccountAdaptor accountAdaptor;

    @GetMapping("/signup")
    public String signUpForm() {
        return "account/signup";
    }

    @PostMapping("/signup")
    public String doSignUp(@ModelAttribute @Valid PostMemberDto postMemberDto) {
        accountAdaptor.createMember(postMemberDto);
        return "account/test";
    }
}
