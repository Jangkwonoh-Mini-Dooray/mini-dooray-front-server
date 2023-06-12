package com.nhnacademy.minidooraygateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "backend.server")
@Getter
@Setter
public class UrlProperties {
    private String accountUrl;
    private String taskUrl;

    public String getTask() {
        return taskUrl + "/projects/{project-id}/posts";
    }
    public String getTaskByTaskId() {
        return taskUrl + "/projects/{project-id}/posts/{task-id}";
    }
}
