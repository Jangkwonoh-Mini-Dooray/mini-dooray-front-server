package com.nhnacademy.minidooraygateway.api.task.dto.comment.mention;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReqCommentMentionDto {
    private List<String> targetMemberId;
}