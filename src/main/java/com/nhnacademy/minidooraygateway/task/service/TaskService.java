package com.nhnacademy.minidooraygateway.task.service;

import com.nhnacademy.minidooraygateway.task.domain.Response;
import com.nhnacademy.minidooraygateway.task.dto.milestone.GetMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.ReqMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.RespMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.ReqProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.RespProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.GetTagDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.ReqTagDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.RespTagDto;
import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
import com.nhnacademy.minidooraygateway.task.dto.task.ReqTaskDto;

import java.util.List;

public interface TaskService {
    RespProjectDto createProject(ReqProjectDto postProjectDto);

    List<GetProjectDto> getProjectsByMemberId(String memberId);

    GetProjectDto getProject(Long projectId);

    Response deleteProject(Long projectId);

    List<GetTaskDto> getTasks(Long projectId);

    GetTaskDto getTask(Long projectId, Long taskId);

    void createTask(ReqTaskDto reqTaskDto, Long projectId);

    void deleteTask(Long taskId);

    List<GetTagDto> getTagsByProjectId(Long projectId);

    List<GetTagDto> getTagsByTaskId(Long projectId, Long taskId);

    void createTag(ReqTagDto reqTagDto, Long projectId);

    void modifyTag(ReqTagDto reqTagDto, Long projectId, Long tagId);

    void deleteTag(Long tagId);

    List<GetMilestoneDto> getMilestones(Long projectId);

    GetMilestoneDto getMilestone(Long milestoneId);

    RespMilestoneDto createMilestone(Long projectId, ReqMilestoneDto reqMilestoneDto);

    RespMilestoneDto modifyMilestone(Long milestoneId, ReqMilestoneDto reqMilestoneDto);

    void deleteMilestone(Long milestoneId);
}
