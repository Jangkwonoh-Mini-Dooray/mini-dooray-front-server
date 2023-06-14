package com.nhnacademy.minidooraygateway.task.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReqTaskDto {
    private String taskWriterMemberId;
    private Long milestoneId;
    private String title;
    private String content;
}
