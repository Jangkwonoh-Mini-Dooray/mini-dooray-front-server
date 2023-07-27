package com.nhnacademy.minidooraygateway.api.task.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqProjectDto {
    private String projectStatusName;
    private String name;
    private String description;
}
