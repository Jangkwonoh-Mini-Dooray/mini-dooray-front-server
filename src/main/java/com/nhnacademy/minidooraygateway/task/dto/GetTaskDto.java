package com.nhnacademy.minidooraygateway.task.dto;

import com.nhnacademy.minidooraygateway.task.domain.Milestone;
import lombok.Getter;

@Getter
public class GetTaskDto {
    private Long taskId;
    private String taskWriterMemberId;
    private Milestone milestone;
    private String title;
}
