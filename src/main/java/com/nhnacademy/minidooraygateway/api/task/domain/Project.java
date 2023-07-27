package com.nhnacademy.minidooraygateway.api.task.domain;

import lombok.Getter;


@Getter
public class Project {
    private Long projectId;
    private ProjectStatus projectStatus;
    private String name;
    private String description;
}
