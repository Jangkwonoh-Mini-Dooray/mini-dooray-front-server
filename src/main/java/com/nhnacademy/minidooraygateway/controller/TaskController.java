package com.nhnacademy.minidooraygateway.controller;

import com.nhnacademy.minidooraygateway.task.dto.milestone.GetMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.ReqMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.ReqTagDto;
import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
import com.nhnacademy.minidooraygateway.task.dto.task.ReqTaskDto;
import com.nhnacademy.minidooraygateway.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/views/{task-id}/{project-id}/{member-id}")
    public String getTask(Model model,
                          @PathVariable("task-id") Long taskId,
                          @PathVariable("project-id") Long projectId,
                          @PathVariable("member-id") String memberId) {
        List<GetProjectDto> projectList = taskService.getProjectsByMemberId(memberId);
        GetTaskDto task = taskService.getTask(projectId, taskId);

        model.addAttribute("projectList", projectList);
        model.addAttribute("task", task);
        model.addAttribute("deleteAction", "/tasks/" + taskId + "/" + projectId + "/" + memberId);

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
        return "redirect:/tasks/" + projectId + "/" + reqTaskDto.getTaskWriterMemberId();
    }

    @DeleteMapping("{task-id}/{project-id}/{member-id}")
    public String deleteTask(Model model,
                             @PathVariable("task-id") Long taskId,
                             @PathVariable("project-id") Long projectId,
                             @PathVariable("member-id") String memberId) {
        taskService.deleteTask(taskId);
        return "redirect:/tasks/" + projectId + "/" + memberId;
    }

    @GetMapping("/milestones/{project-id}")
    public String  getMilestones(Model model,
                                 @PathVariable("project-id") Long projectId) {
        List<GetMilestoneDto> milestoneList = taskService.getMilestones(projectId);
        model.addAttribute("milestoneList", milestoneList);
        return "milestone/list";
    }

    @GetMapping("/milestones/views/{milestone-id}")
    public String getMilestone(Model model,
                               @PathVariable("milestone-id") Long milestoneId) {
        GetMilestoneDto milestone = taskService.getMilestone(milestoneId);
        model.addAttribute("milestone", milestone);
        return "milestone/view";
    }

    @GetMapping("/milestones/{project-id}/create")
    public String createMilestoneForm(Model model,
                                      @PathVariable("project-id") Long projectId) {
        model.addAttribute("reqMilestoneDto", new ReqMilestoneDto());
        model.addAttribute("action", "/milestone/" + projectId + "/create");
        return "milestone/form";
    }

    @PostMapping("/milestones/{project-id}/create")
    public String createMilestone(@PathVariable("project-id") Long projectId,
                                  ReqMilestoneDto reqMilestoneDto) {
        taskService.createMilestone(projectId, reqMilestoneDto);
        return "redirect:/milestones/" + projectId;
    }

    @GetMapping("/milestones/{project-id}/modify/{milestone-id}")
    public String modifyMilestoneForm(Model model,
                                      @PathVariable("project-id") Long projectId,
                                      @PathVariable("milestond-id") Long milestoneId) {
        model.addAttribute("reqMilestoneDto", new ReqMilestoneDto());
        model.addAttribute("action", "/milestones/" + projectId + "/modify/" + milestoneId);
        return "milestone/form";
    }

    @PostMapping("/milestones/{project-id}/modify/{milestone-id}")
    public String modifyMilestone(@PathVariable("project-id") Long projectId,
                                  @PathVariable("milestone-id") Long milestoneId,
                                  ReqMilestoneDto reqMilestoneDto) {
        taskService.modifyMilestone(milestoneId, reqMilestoneDto);
        return "redirect:/milestones/" + projectId;
    }
}
