package com.nhnacademy.minidooraygateway.task.dto.milestone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetMilestoneDto {
    private Long milestoneId;
    private String name;
    private LocalDate startPeriod;
    private LocalDate endPeriod;
    private String status;
}
