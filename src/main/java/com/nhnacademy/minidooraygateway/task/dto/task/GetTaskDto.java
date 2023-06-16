package com.nhnacademy.minidooraygateway.task.dto.task;

import com.nhnacademy.minidooraygateway.task.domain.Milestone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetTaskDto {
    private Long taskId;
    private String taskWriterMemberId;
    private Long milestoneId;
    private String title;
    private String content;
}
