package com.nhnacademy.minidooraygateway.task.dto.tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetTagDto {
    private Long tagId;
    private String name;
}
