package com.nhnacademy.minidooraygateway.api.task.dto.task;

import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetTaskDto {
    private Long taskId;
    private String taskWriterMemberId;
    @Nullable
    private Long milestoneId;
    private String title;
    private String content;
}
