package com.nhnacademy.minidooraygateway.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
public class ProjectStatus {
    private int projectStatusId;
    private String name;
}
