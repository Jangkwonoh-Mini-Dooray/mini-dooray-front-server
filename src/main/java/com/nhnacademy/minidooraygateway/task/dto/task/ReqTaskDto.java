package com.nhnacademy.minidooraygateway.task.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;

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
