package com.nhnacademy.minidooraygateway.task.service;

import com.nhnacademy.minidooraygateway.account.adaptor.AccountAdaptor;
import com.nhnacademy.minidooraygateway.task.adaptor.TaskAdaptor;
import com.nhnacademy.minidooraygateway.task.domain.Response;
import com.nhnacademy.minidooraygateway.task.dto.milestone.GetMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.ReqMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.RespMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.GetTagDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.ReqTagDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.RespTagDto;
import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
import com.nhnacademy.minidooraygateway.task.dto.task.ReqTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultTaskService implements TaskService {
    private final TaskAdaptor taskAdaptor;

    @Override
    public List<GetProjectDto> getProjectsByMemberId(String memberId) {
        return taskAdaptor.getProjectsByMemberId(memberId);
    }

    @Override
    public GetProjectDto getProject(Long projectId) {
        return taskAdaptor.getProject(projectId);
    }

    @Override
    public List<GetTaskDto> getTasks(Long projectId) {
        return taskAdaptor.getTasks(projectId);
    }

    @Override
    public GetTaskDto getTask(Long projectId, Long taskId) {
        return taskAdaptor.getTask(projectId, taskId);
    }

    @Override
    public void createTask(ReqTaskDto reqTaskDto, Long projectId) {
        taskAdaptor.createTask(reqTaskDto, projectId);
    }

    @Override
    public void createTag(ReqTagDto reqTagDto, Long projectId) {
        taskAdaptor.createTag(reqTagDto, projectId);
    }

    @Override
    public List<GetTagDto> getTagsByProjectId(Long projectId) {
        return taskAdaptor.getTags(projectId);
    }

    @Override
    public List<GetTagDto> getTagsByTaskId(Long projectId, Long taskId) {
        return taskAdaptor.getTagsByTags(projectId, taskId);
    }

    @Override
    public RespTagDto postTagOfTask(ReqTagDto reqTagDto, Long projectId) {
        return taskAdaptor.createTag(reqTagDto,  projectId);
    }

    @Override
    public ReqTagDto modifyTagOfTask(ReqTagDto reqTagDto, Long projectId, Long tagId) {
        return taskAdaptor.modifyTag(reqTagDto, projectId, tagId);
    }

    @Override
    public Response deleteTag(Long tagId) {
        return taskAdaptor.deleteTag(tagId);
    }

    @Override
    public List<GetMilestoneDto> getMilestones(Long projectId) {
        return taskAdaptor.getMilestones(projectId);
    }

    @Override
    public GetMilestoneDto getMilestone(Long milestoneId) {
        return taskAdaptor.getMilestone(milestoneId);
    }

    @Override
    public RespMilestoneDto createMilestone(Long projectId, ReqMilestoneDto reqMilestoneDto) {
        return taskAdaptor.createMilestone(projectId, reqMilestoneDto);
    }

    @Override
    public RespMilestoneDto modifyMilestone(Long milestoneId, ReqMilestoneDto reqMilestoneDto) {
        return taskAdaptor.modifyMilestone(milestoneId, reqMilestoneDto);
    }

    @Override
    public void deleteMilestone(Long milestoneId) {
        taskAdaptor.deleteMilestone(milestoneId);
    }
}
