package com.nhnacademy.minidooraygateway.controller;

import com.nhnacademy.minidooraygateway.task.adaptor.TaskAdaptor;
import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskAdaptor taskAdaptor;

    @GetMapping
    public String getTasks(Model model,
                           @PathVariable("project-id") Long projectId) {
        List<GetTaskDto> taskList = taskAdaptor.getTasks(projectId);
        model.addAttribute("taskList", taskList);
        return "task/list";
    }
}
