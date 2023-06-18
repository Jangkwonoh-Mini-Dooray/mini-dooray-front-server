package com.nhnacademy.minidooraygateway.controller;

import com.nhnacademy.minidooraygateway.task.dto.milestone.GetMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.ReqMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.GetTagDto;
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
        model.addAttribute("modifyAction", "/tasks/" + projectId + "/modify/" + taskId);

        return "task/view";
    }

    @GetMapping("/{project-id}/write")
    public String createTaskForm(Model model,
                            @PathVariable("project-id") Long projectId) {
        // 업무
        model.addAttribute("reqTaskDto", new ReqTaskDto());
        model.addAttribute("action", "/tasks/" + projectId);

        // 태그
        model.addAttribute("reqTagDto", new ReqTagDto());
        // 마일스톤
        model.addAttribute("reqMilestoneDto", new ReqMilestoneDto());
        return "task/create-form";
    }

    @PostMapping("/{project-id}")
    public String createTask(@PathVariable("project-id") Long projectId,
                             ReqTaskDto reqTaskDto) {
        taskService.createTask(reqTaskDto, projectId);

        return "redirect:/tasks/" + projectId + "/" + reqTaskDto.getTaskWriterMemberId();
    }

    @GetMapping("/{project-id}/modify/{task-id}")
    public String modifyTaskForm(Model model,
                                 @PathVariable("project-id") Long projectId,
                                 @PathVariable("task-id") Long taskId) {
        GetTaskDto task = taskService.getTask(projectId, taskId);
        model.addAttribute("task", task);
        model.addAttribute("reqTaskDto", new ReqTaskDto());
        model.addAttribute("action", "/tasks/" + projectId + "/modify/" + taskId);
        return "task/modify-form";
    }

    @PutMapping("/{project-id}/modify/{task-id}")
    public String modifyTask(@PathVariable("project-id") Long projectId,
                             @PathVariable("task-id") Long taskId,
                             ReqTaskDto reqTaskDto) {
        taskService.modifyTask(reqTaskDto, projectId, taskId);

        return "redirect:/tasks/" + projectId + "/" + reqTaskDto.getTaskWriterMemberId();
    }

    @DeleteMapping("/{task-id}/{project-id}/{member-id}")
    public String deleteTask(Model model,
                             @PathVariable("task-id") Long taskId,
                             @PathVariable("project-id") Long projectId,
                             @PathVariable("member-id") String memberId) {
        taskService.deleteTask(taskId);
        return "redirect:/tasks/" + projectId + "/" + memberId;
    }

    @GetMapping("/milestones/{project-id}")
    public String getMilestones(Model model,
                                @PathVariable("project-id") Long projectId) {
        List<GetMilestoneDto> milestoneList = taskService.getMilestones(projectId);
        String projectName = taskService.getProject(projectId).getName();

        model.addAttribute("projectId", projectId);
        model.addAttribute("milestoneList", milestoneList);
        model.addAttribute("projectName", projectName);
        return "milestone/list";
    }

    @GetMapping("/milestones/{project-id}/create")
    public String createMilestoneForm(Model model,
                                      @PathVariable("project-id") Long projectId) {
        model.addAttribute("reqMilestoneDto", new ReqMilestoneDto());
        model.addAttribute("action", "/tasks/milestones/" + projectId + "/create");
        return "milestone/create-form";
    }

    @PostMapping("/milestones/{project-id}/create")
    public String createMilestone(@PathVariable("project-id") Long projectId,
                                  ReqMilestoneDto reqMilestoneDto) {
        taskService.createMilestone(projectId, reqMilestoneDto);
        return "redirect:/tasks/milestones/" + projectId;
    }

    @GetMapping("/milestones/{project-id}/modify/{milestone-id}")
    public String modifyMilestoneForm(Model model,
                                      @PathVariable("project-id") Long projectId,
                                      @PathVariable("milestone-id") Long milestoneId) {
        GetMilestoneDto milestone = taskService.getMilestone(milestoneId);
        model.addAttribute("milestone", milestone);
        model.addAttribute("reqMilestoneDto", new ReqMilestoneDto());
        model.addAttribute("action", "/tasks/milestones/" + projectId + "/modify/" + milestoneId);
        return "milestone/modify-form";
    }

    @PutMapping("/milestones/{project-id}/modify/{milestone-id}")
    public String modifyMilestone(@PathVariable("project-id") Long projectId,
                                  @PathVariable("milestone-id") Long milestoneId,
                                  ReqMilestoneDto reqMilestoneDto) {
        taskService.modifyMilestone(milestoneId, reqMilestoneDto);
        return "redirect:/tasks/milestones/" + projectId;
    }

    @DeleteMapping("/milestones/delete/{project-id}")
    public String deleteMilestone(@PathVariable("project-id") Long projectId,
                                  Long milestoneId) {
        taskService.deleteMilestone(milestoneId);
        return "redirect:/tasks/milestones/" + projectId;
    }

    @GetMapping("/tags/{project-id}")
    public String getTags(Model model,
                          @PathVariable("project-id") Long projectId) {
        List<GetTagDto> tagList = taskService.getTagsByProjectId(projectId);
        String projectName = taskService.getProject(projectId).getName();

        model.addAttribute("projectId", projectId);
        model.addAttribute("tagList", tagList);
        model.addAttribute("projectName", projectName);
        model.addAttribute("reqTagDto", new ReqTagDto());
        model.addAttribute("action", "/tasks/tags/" + projectId + "/create");
        return "tag/list";
    }

    @PostMapping("/tags/{project-id}/create")
    public String createTag(@PathVariable("project-id") Long projectId,
                                  ReqTagDto reqTagDto) {
        taskService.createTag(reqTagDto, projectId);
        return "redirect:/tasks/tags/" + projectId;
    }

    @DeleteMapping("/tags/delete/{project-id}")
    public String deleteTag(@PathVariable("project-id") Long projectId,
                                  Long tagId) {
        taskService.deleteTag(tagId);
        return "redirect:/tasks/tags/" + projectId;
    }
}
