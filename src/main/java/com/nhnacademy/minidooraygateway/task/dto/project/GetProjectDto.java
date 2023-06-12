package com.nhnacademy.minidooraygateway.task.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProjectDto {
    private Long projectId;
    private String projectStatusName;
    private String name;
    private String description;
}
