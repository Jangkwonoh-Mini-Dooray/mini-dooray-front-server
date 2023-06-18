package com.nhnacademy.minidooraygateway.task.service;

import com.nhnacademy.minidooraygateway.account.adaptor.AccountAdaptor;
import com.nhnacademy.minidooraygateway.task.adaptor.TaskAdaptor;
import com.nhnacademy.minidooraygateway.task.dto.milestone.GetMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.ReqMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.RespMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.ReqProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.RespProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.member.RespProjectMemberDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.GetTagDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.ReqTagDto;
import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
import com.nhnacademy.minidooraygateway.task.dto.task.ReqTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultTaskService implements TaskService {
    private final TaskAdaptor taskAdaptor;
    private final AccountAdaptor accountAdaptor;

    @Override
    public RespProjectDto createProject(ReqProjectDto postProjectDto) {
        return taskAdaptor.createProject(postProjectDto);
    }

    @Override
    public List<GetProjectDto> getProjectsByMemberId(String memberId) {
        return taskAdaptor.getProjectsByMemberId(memberId);
    }

    @Override
    public GetProjectDto getProject(Long projectId) {
        return taskAdaptor.getProject(projectId);
    }

    @Override
    public void modifyProject(Long projectId, ReqProjectDto reqProjectDto) {
        taskAdaptor.modifyProject(projectId, reqProjectDto);
    }
    @Override
    public void deleteProject(Long projectId) {
        taskAdaptor.deleteProject(projectId);
    }

    @Override
    public void createProjectMember(Long projectId, String[] members) {
        List<RespProjectMemberDto> respProjectMemberDtoList = new ArrayList<>();
        for (String targetMemberId : members) {
            respProjectMemberDtoList.add(new RespProjectMemberDto(2, targetMemberId));
        }
        taskAdaptor.addProjectMembers(projectId, respProjectMemberDtoList);
    }

    @Override
    public void modifyProjectMember(Long projectId, String[] members) {
        List<RespProjectMemberDto> respProjectMemberDtoList = new ArrayList<>();
        for (String targetMemberId : members) {
            respProjectMemberDtoList.add(new RespProjectMemberDto(2, targetMemberId));
        }
        taskAdaptor.modifyProjectMembers(projectId, respProjectMemberDtoList);
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
    public void modifyTask(ReqTaskDto reqTaskDto, Long projectId, Long taskId) {
        taskAdaptor.modifyTask(reqTaskDto, projectId, taskId);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskAdaptor.deleteTask(taskId);
    }

    @Override
    public List<GetTagDto> getTagsByProjectId(Long projectId) {
        return taskAdaptor.getTags(projectId);
    }

    @Override
    public List<GetTagDto> getTagsByTaskId(Long projectId, Long taskId) {
        return taskAdaptor.getTagsByTaskId(projectId, taskId);
    }

    @Override
    public void createTag(ReqTagDto reqTagDto, Long projectId) {
        taskAdaptor.createTag(reqTagDto, projectId);
    }

    @Override
    public void modifyTag(ReqTagDto reqTagDto, Long projectId, Long tagId) {
        taskAdaptor.modifyTag(reqTagDto, projectId, tagId);
    }

    @Override
    public void deleteTag(Long tagId) {
        taskAdaptor.deleteTag(tagId);
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
