package com.nhnacademy.minidooraygateway.task.dto.project.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespProjectMemberDto {
    private int projectAuthorityId;
    private String targetMemberId;
}
