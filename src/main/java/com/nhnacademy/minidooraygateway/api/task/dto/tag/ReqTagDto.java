package com.nhnacademy.minidooraygateway.api.task.dto.tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqTagDto {
    private Long taskId;
    private String name;
}
