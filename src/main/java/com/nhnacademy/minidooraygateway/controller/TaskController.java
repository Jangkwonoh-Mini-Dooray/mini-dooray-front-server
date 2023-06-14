package com.nhnacademy.minidooraygateway.controller;

import com.nhnacademy.minidooraygateway.task.dto.milestone.ReqMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.ReqTagDto;
import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
import com.nhnacademy.minidooraygateway.task.dto.task.ReqTaskDto;
import com.nhnacademy.minidooraygateway.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{project-id}/{member-id}")
    public String getTasks(Model model,
                           @PathVariable("project-id") Long projectId,
                           @PathVariable("member-id") String memberId) {
        List<GetTaskDto> taskList = taskService.getTasks(projectId);
        List<GetProjectDto> projectList = taskService.getProjectsByMemberId(memberId);
        GetProjectDto project = taskService.getProject(projectId);

        model.addAttribute("taskList", taskList);
        model.addAttribute("projectList", projectList);
        model.addAttribute("projectId", projectId);
        model.addAttribute("projectName", project.getName());

        return "task/list";
    }

    @GetMapping("/views/{task-id}")
    public String getTask(Model model,
                          @PathVariable("project-id") Long projectId,
                          @PathVariable("task-id") Long taskId) {
        GetTaskDto task = taskService.getTask(projectId, taskId);
        model.addAttribute("task", task);
        return "task/view";
    }

    @GetMapping("/{project-id}/write")
    public String writeTask(Model model,
                            @PathVariable("project-id") Long projectId) {
        // 업무
        model.addAttribute("reqTaskDto", new ReqTaskDto());
        model.addAttribute("action", "/tasks/" + projectId);

        // 태그
        model.addAttribute("reqTagDto", new ReqTagDto());
        // 마일스톤
        model.addAttribute("reqMilestoneDto", new ReqMilestoneDto());
        return "task/write";
    }

    @PostMapping("/{project-id}")
    public String createTask(@PathVariable("project-id") Long projectId,
                             ReqTaskDto reqTaskDto,
                             ReqTagDto reqTagDto) {
        taskService.createTask(reqTaskDto, projectId);
//        taskService.createTag(reqTagDto, projectId);
        return "redirect:/tasks/" + projectId;
    }


}
