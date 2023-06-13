package com.nhnacademy.minidooraygateway.task.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqCommentDto {
    private String commentWriterMemberId;
    private String comment;
}

