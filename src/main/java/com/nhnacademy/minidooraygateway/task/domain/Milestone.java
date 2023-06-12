package com.nhnacademy.minidooraygateway.task.domain;

import lombok.Getter;
import java.time.LocalDate;

@Getter
public class Milestone {
    private Long milestoneId;
    private String name;
    private LocalDate startPeriod;
    private LocalDate endPeriod;
    private String status;
    private Project project;
}
