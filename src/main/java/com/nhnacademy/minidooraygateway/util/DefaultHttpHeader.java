package com.nhnacademy.minidooraygateway.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

public class DefaultHttpHeader {
    public static HttpHeaders getHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }
}
