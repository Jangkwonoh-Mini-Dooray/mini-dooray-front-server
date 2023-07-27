package com.nhnacademy.minidooraygateway.api.task.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCommentDto {
    private Long commentId;
    private String commentWriterMemberId;
    private String comment;
}
