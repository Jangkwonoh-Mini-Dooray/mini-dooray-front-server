package com.nhnacademy.minidooraygateway.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2GitEmail {
    private String email;
    private Boolean primary;
    private Boolean verified;
    private String visibility;
}
