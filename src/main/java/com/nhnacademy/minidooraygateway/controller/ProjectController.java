package com.nhnacademy.minidooraygateway.controller;

import com.nhnacademy.minidooraygateway.task.adaptor.TaskAdaptor;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.ReqProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
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
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final TaskService taskService;

    @GetMapping
    public String welcomePage() {
        return "project/welcome";
    }

    @GetMapping("/{member-id}")
    public String main(Model model,
                           @PathVariable("member-id") String memberId) {
        List<GetProjectDto> projectList = taskService.getProjectsByMemberId(memberId);
        model.addAttribute("projectList", projectList);

        if (projectList.isEmpty()) {
            return "project/main";
        }

        Long defaultProjectId = projectList.get(0).getProjectId();
        GetProjectDto project = taskService.getProject(defaultProjectId);
        model.addAttribute("defaultProjectId", defaultProjectId);
        List<GetTaskDto> defaultTaskList = taskService.getTasks(defaultProjectId);
        model.addAttribute("defaultTaskList", defaultTaskList);
        model.addAttribute("projectName", project.getName());

        return "project/main";
    }

    @GetMapping("/create")
    public String createProjectForm() {
        return "project/createProjectForm";
    }

    @PostMapping("/create/{member-id}")
    public String createProject(ReqProjectDto reqProjectDto, @PathVariable("member-id") String memberId) {
        taskService.createProject(reqProjectDto);
        return "redirect:/projects/main";
    }
}
