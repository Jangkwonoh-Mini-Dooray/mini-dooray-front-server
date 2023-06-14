package com.nhnacademy.minidooraygateway.controller;

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

    @GetMapping("/{project-id}")
    public String getTasks(Model model,
                           @PathVariable("project-id") Long projectId) {
        List<GetTaskDto> taskList = taskService.getTasks(projectId);
        model.addAttribute("taskList", taskList);
        return "task/list";
    }

    @GetMapping("/{project-id}/write")
    public String writeTask(Model model,
                           @PathVariable("project-id") Long projectId) {
        model.addAttribute("reqTaskDto", new ReqTaskDto());
        model.addAttribute("action", "/tasks/" + projectId);
        return "task/write";
    }

    @PostMapping("/{project-id}")
    public String createTask(@PathVariable("project-id") Long projectId,
                           ReqTaskDto reqTaskDto) {
        taskService.createTask(reqTaskDto, projectId);
        return "redirect:/tasks/" + projectId;
    }


}
