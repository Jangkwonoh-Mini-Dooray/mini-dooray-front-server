package com.nhnacademy.minidooraygateway.task.dto.task;

import com.nhnacademy.minidooraygateway.task.domain.Milestone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetTaskDto {
    private Long taskId;
    private String taskWriterMemberId;
    private Milestone milestone;
    private String title;
}
