package com.nhnacademy.minidooraygateway.controller;

import com.nhnacademy.minidooraygateway.account.dto.member.GetMemberDto;
import com.nhnacademy.minidooraygateway.account.service.AccountService;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.ReqProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.RespProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.member.ReqProjectMemberDto;
import com.nhnacademy.minidooraygateway.task.dto.project.member.RespProjectMemberDto;
import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
import com.nhnacademy.minidooraygateway.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final TaskService taskService;
    private final AccountService accountService;

    @GetMapping
    public String welcomePage() {
        return "project/welcome";
    }

    @GetMapping("/{member-id}")
    public String getProjects(Model model,
                              @PathVariable("member-id") String memberId) {
        List<GetProjectDto> projectList = taskService.getProjectsByMemberId(memberId);
        model.addAttribute("projectList", projectList);
        model.addAttribute("createProjectLink", "/projects/" + memberId + "/create");
        return "project/list";
    }

    @GetMapping("/{member-id}/create")
    public String createProjectForm(Model model,
                                    @PathVariable("member-id") String memberId) {
        model.addAttribute("reqProjectDto", new ReqProjectDto());
        model.addAttribute("action", "/projects/" + memberId + "/create");
        return "project/create-form";
    }

    @PostMapping("/{member-id}/create")
    public String createProject(ReqProjectDto reqProjectDto,
                                @PathVariable("member-id") String memberId) {
        RespProjectDto respProjectDto = taskService.createProject(reqProjectDto);
        return "redirect:/projects/members/" + memberId + "/create/" + respProjectDto.getProjectId();
    }

    @GetMapping("/{member-id}/modify/{project-id}")
    public String modifyProjectForm(Model model,
                                    @PathVariable("member-id") String memberId,
                                    @PathVariable("project-id") Long projectId) {
        model.addAttribute("reqProjectDto", new ReqProjectDto());
        model.addAttribute("action", "/projects/" + memberId + "/modify/" + projectId);
        return "project/create-form";
    }

    @PutMapping("/{member-id}/modify/{project-id}")
    public String modifyProject(ReqProjectDto reqProjectDto,
                                @PathVariable("member-id") String memberId,
                                @PathVariable("project-id") Long projectId) {
        taskService.modifyProject(projectId, reqProjectDto);
        return "redirect:/projects/" + memberId;
    }

    @DeleteMapping
    public void deleteProject(Long projectId) {
        taskService.deleteProject(projectId);
    }

    @GetMapping("/members/{member-id}/create/{project-id}")
    public String createProjectMemberForm(Model model,
                                          @PathVariable("member-id") String memberId,
                                          @PathVariable("project-id") Long projectId) {
        List<GetMemberDto> members = accountService.getMembers();
        model.addAttribute("members", members);
        model.addAttribute("projectId", projectId);
        model.addAttribute("action", "/projects/members/" + memberId + "/create/" + projectId);
        return "member/create-form";
    }

    @PostMapping("/members/{member-id}/create/{project-id}")
    public String createProjectMember(@PathVariable("member-id") String memberId,
                                      @PathVariable("project-id") Long projectId,
                                      String[] memberList) {
        taskService.createProjectMember(projectId, memberList);
        return "redirect:/projects/" + memberId;
    }
}
