package com.nhnacademy.minidooraygateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.backend.server")
@Getter
@Setter
public class UrlProperties {
    private String accountServerUrl;
    private String taskServerUrl;
}
