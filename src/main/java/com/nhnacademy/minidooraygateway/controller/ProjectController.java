package com.nhnacademy.minidooraygateway.controller;

import com.nhnacademy.minidooraygateway.task.adaptor.TaskAdaptor;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final TaskAdaptor taskAdaptor;

    @GetMapping
    public String main() {
        return "project/main";
    }

    @GetMapping("{member-id}")
    public String getProjects(Model model,
                           @PathVariable("member-id") String memberId) {
        List<GetProjectDto> projectList = taskAdaptor.getProjectsByMemberId(memberId);
        model.addAttribute("projectList", projectList);
        return "project/list";
    }


}
