package com.nhnacademy.minidooraygateway.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
public class Project {
    private Long projectId;
    private ProjectStatus projectStatus;
    private String name;
    private String description;
}