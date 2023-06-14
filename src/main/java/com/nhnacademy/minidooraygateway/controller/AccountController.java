package com.nhnacademy.minidooraygateway.controller;

import com.nhnacademy.minidooraygateway.account.dto.member.PostMemberDto;
import com.nhnacademy.minidooraygateway.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/login")
    public String loginForm() {
        return "account/login";
    }

    @GetMapping("/signup")
    public String signUpForm() {
        return "account/signup";
    }

    @PostMapping("/signup")
    public String doSignUp(@ModelAttribute @Valid PostMemberDto postMemberDto) {
        accountService.createMember(postMemberDto);
        return "redirect:/login";
    }
}
