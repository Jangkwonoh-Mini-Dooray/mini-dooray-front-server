package com.nhnacademy.minidooraygateway.api.task.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqTaskDto {
    private String taskWriterMemberId;
    private Long milestoneId;
    private String title;
    private String content;
}
