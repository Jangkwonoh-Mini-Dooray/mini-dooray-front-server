package com.nhnacademy.minidooraygateway.task.adaptor;

import com.nhnacademy.minidooraygateway.config.UrlProperties;
import com.nhnacademy.minidooraygateway.task.domain.Project;
import com.nhnacademy.minidooraygateway.task.domain.Response;
import com.nhnacademy.minidooraygateway.task.dto.comment.GetCommentDto;
import com.nhnacademy.minidooraygateway.task.dto.comment.ReqCommentDto;
import com.nhnacademy.minidooraygateway.task.dto.comment.RespCommentDto;
import com.nhnacademy.minidooraygateway.task.dto.comment.mention.ReqCommentMentionDto;
import com.nhnacademy.minidooraygateway.task.dto.comment.mention.RespCommentMentionDto;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.ReqProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.RespProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.authority.ProjectAuthorityDto;
import com.nhnacademy.minidooraygateway.task.dto.project.authority.ProjectAuthorityIdDto;
import com.nhnacademy.minidooraygateway.task.dto.project.authority.ProjectAuthorityNameDto;
import com.nhnacademy.minidooraygateway.task.dto.project.member.ReqProjectMemberDto;
import com.nhnacademy.minidooraygateway.task.dto.project.member.RespProjectMemberDto;
import com.nhnacademy.minidooraygateway.task.dto.project.status.ProjectStatusDto;
import com.nhnacademy.minidooraygateway.task.dto.project.status.ProjectStatusIdDto;
import com.nhnacademy.minidooraygateway.task.dto.project.status.ProjectStatusNameDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.GetTagDto;
import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.GetMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.ReqMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.RespMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.ReqTagDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.RespTagDto;
import com.nhnacademy.minidooraygateway.task.dto.task.ReqTaskDto;
import com.nhnacademy.minidooraygateway.task.dto.task.RespTaskDto;
import com.nhnacademy.minidooraygateway.util.DefaultHttpHeader;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskAdaptor {
    private final RestTemplate restTemplate;
    private final UrlProperties urlProperties;

    public List<GetProjectDto> getProjectsByMemberId(String memberId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<GetProjectDto>> exchange =
                restTemplate.exchange(urlProperties.getProjectByMemberId(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, memberId);
        return exchange.getBody();
    }


    public List<Project> getProjects() {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<Project>> exchange =
                restTemplate.exchange(urlProperties.getProjects(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        return exchange.getBody();
    }

    public GetProjectDto getProject(Long projectId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<GetProjectDto> exchange =
                restTemplate.exchange(urlProperties.getProject(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public RespProjectDto createProject(ReqProjectDto postProjectDto) {
        HttpEntity<ReqProjectDto> requestEntity = new HttpEntity<>(postProjectDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespProjectDto> exchange =
                restTemplate.exchange(urlProperties.createProject(),
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        return exchange.getBody();
    }

    public RespProjectDto modifyProject(Long projectId, ReqProjectDto putProjectDto) {
        HttpEntity<ReqProjectDto> requestEntity = new HttpEntity<>(putProjectDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespProjectDto> exchange =
                restTemplate.exchange(urlProperties.modifyProject(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public Response deleteProject(Long projectId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<Response> exchange =
                restTemplate.exchange(urlProperties.deleteProject(),
                        HttpMethod.DELETE,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public RespProjectMemberDto getProjectMembers(Long projectId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<RespProjectMemberDto> exchange =
                restTemplate.exchange(urlProperties.getProjectMembers(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public Response addProjectMembers(Long projectId, List<RespProjectMemberDto> respProjectMemberDtoList) {
        HttpEntity<List<RespProjectMemberDto>> requestEntity = new HttpEntity<>(respProjectMemberDtoList, DefaultHttpHeader.getHeader());

        ResponseEntity<Response> exchange =
                restTemplate.exchange(urlProperties.addProjectMembers(),
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public Response modifyProjectMembers(Long projectId, List<RespProjectMemberDto> respProjectMemberDtoList) {
        HttpEntity<List<RespProjectMemberDto>> requestEntity = new HttpEntity<>(respProjectMemberDtoList, DefaultHttpHeader.getHeader());

        ResponseEntity<Response> exchange =
                restTemplate.exchange(urlProperties.modifyProjectMembers(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public Response deleteProjectMembers(Long projectId, List<ReqProjectMemberDto> reqProjectMemberDtoList) {
        HttpEntity<List<ReqProjectMemberDto>> requestEntity = new HttpEntity<>(reqProjectMemberDtoList, DefaultHttpHeader.getHeader());

        ResponseEntity<Response> exchange =
                restTemplate.exchange(urlProperties.deleteProjectMembers(),
                        HttpMethod.DELETE,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public List<GetTaskDto> getTasks(Long projectId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<GetTaskDto>> exchange =
                restTemplate.exchange(urlProperties.getTasks(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public GetTaskDto getTask(Long projectId, Long taskId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<GetTaskDto> exchange =
                restTemplate.exchange(urlProperties.getTask(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId, taskId);
        return exchange.getBody();
    }

    public RespTaskDto createTask(ReqTaskDto postTaskDto, Long projectId) {
        HttpEntity<ReqTaskDto> requestEntity = new HttpEntity<>(postTaskDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespTaskDto> exchange =
                restTemplate.exchange(urlProperties.createTask(),
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public RespTaskDto modifyTask(ReqTaskDto postTaskDto, Long projectId, Long taskId) {
        HttpEntity<ReqTaskDto> requestEntity = new HttpEntity<>(postTaskDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespTaskDto> exchange =
                restTemplate.exchange(urlProperties.modifyTask(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId, taskId);
        return exchange.getBody();
    }

    public void deleteTask(Long taskId) {
        String url = UriComponentsBuilder.fromUriString(urlProperties.deleteTask())
                .buildAndExpand(taskId)
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        restTemplate.exchange(url, HttpMethod.DELETE, entity, Void.class);
    }

    public List<GetMilestoneDto> getMilestones(Long projectId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<GetMilestoneDto>> exchange =
                restTemplate.exchange(urlProperties.getMilestones(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public GetMilestoneDto getMilestone(Long milestoneId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<GetMilestoneDto> exchange =
                restTemplate.exchange(urlProperties.getMilestone(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, milestoneId);
        return exchange.getBody();
    }

    public RespMilestoneDto createMilestone(Long projectId, ReqMilestoneDto reqMilestoneDto) {
        HttpEntity<ReqMilestoneDto> requestEntity = new HttpEntity<>(reqMilestoneDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespMilestoneDto> exchange =
                restTemplate.exchange(urlProperties.createMilestone(),
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public RespMilestoneDto modifyMilestone(Long milestoneId, ReqMilestoneDto reqMilestoneDto) {
        HttpEntity<ReqMilestoneDto> requestEntity = new HttpEntity<>(reqMilestoneDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespMilestoneDto> exchange =
                restTemplate.exchange(urlProperties.modifyMilestone(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, milestoneId);
        return exchange.getBody();
    }

    public void deleteMilestone(Long milestoneId) {
        String url = UriComponentsBuilder.fromUriString(urlProperties.deleteMilestone())
                .buildAndExpand(milestoneId)
                .toUriString();
        restTemplate.delete(url);
    }

    public List<GetTagDto> getTags(Long projectId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<GetTagDto>> exchange =
                restTemplate.exchange(urlProperties.getTags(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public List<GetTagDto> getTagsByTags(Long projectId, Long taskId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<GetTagDto>> exchange =
                restTemplate.exchange(urlProperties.getTagsByTags(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId, taskId);
        return exchange.getBody();
    }

    public RespTagDto createTag(ReqTagDto reqTagDto, Long projectId) {
        HttpEntity<ReqTagDto> requestEntity = new HttpEntity<>(reqTagDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespTagDto> exchange =
                restTemplate.exchange(urlProperties.createTag(),
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public ReqTagDto modifyTag(ReqTagDto reqTagDto, Long projectId, Long tagId) {
        HttpEntity<ReqTagDto> requestEntity = new HttpEntity<>(reqTagDto, DefaultHttpHeader.getHeader());

        ResponseEntity<ReqTagDto> exchange =
                restTemplate.exchange(urlProperties.modifyTag(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId, tagId);
        return exchange.getBody();
    }

    public Response deleteTag(Long tagId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());
        ResponseEntity<Response> exchange =
                restTemplate.exchange(urlProperties.deleteTag(),
                        HttpMethod.DELETE,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, tagId);
        return exchange.getBody();
    }

    public List<ProjectAuthorityDto> getProjectAuthorities() {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<ProjectAuthorityDto>> exchange =
                restTemplate.exchange(urlProperties.getProjectAuthorities(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        return exchange.getBody();
    }

    public ProjectAuthorityNameDto getProjectAuthority(int projectAuthorityId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<ProjectAuthorityNameDto> exchange =
                restTemplate.exchange(urlProperties.getProjectAuthority(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectAuthorityId);
        return exchange.getBody();
    }

    public ProjectAuthorityIdDto createProjectAuthority(ProjectAuthorityDto projectAuthorityDto) {
        HttpEntity<ProjectAuthorityDto> requestEntity = new HttpEntity<>(projectAuthorityDto, DefaultHttpHeader.getHeader());

        ResponseEntity<ProjectAuthorityIdDto> exchange =
                restTemplate.exchange(urlProperties.createProjectAuthority(),
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        return exchange.getBody();
    }

    public ProjectAuthorityIdDto updateProjectAuthority(int projectAuthorityId, ProjectAuthorityNameDto projectAuthorityNameDto) {
        HttpEntity<ProjectAuthorityNameDto> requestEntity = new HttpEntity<>(projectAuthorityNameDto, DefaultHttpHeader.getHeader());

        ResponseEntity<ProjectAuthorityIdDto> exchange =
                restTemplate.exchange(urlProperties.updateProjectAuthority(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectAuthorityId);
        return exchange.getBody();
    }

    public void deleteProjectAuthority(int projectAuthorityId) {
        String url = UriComponentsBuilder.fromUriString(urlProperties.deleteProjectAuthority())
                .buildAndExpand(projectAuthorityId)
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        restTemplate.exchange(url, HttpMethod.DELETE, entity, Void.class);
    }

    public List<ProjectStatusDto> getProjectStatuses() {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<ProjectStatusDto>> exchange =
                restTemplate.exchange(urlProperties.getProjectStatuses(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        return exchange.getBody();
    }

    public ProjectStatusNameDto getProjectStatus(int projectStatusId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<ProjectStatusNameDto> exchange =
                restTemplate.exchange(urlProperties.getProjectStatus(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectStatusId);
        return exchange.getBody();
    }

    public ProjectStatusIdDto createProjectStatus(ProjectStatusDto projectStatusDto) {
        HttpEntity<ProjectStatusDto> requestEntity = new HttpEntity<>(projectStatusDto, DefaultHttpHeader.getHeader());

        ResponseEntity<ProjectStatusIdDto> exchange =
                restTemplate.exchange(urlProperties.createProjectStatus(),
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        });
        return exchange.getBody();
    }

    public ProjectStatusIdDto updateProjectStatus(int projectStatusId, ProjectStatusNameDto projectStatusNameDto) {
        HttpEntity<ProjectStatusNameDto> requestEntity = new HttpEntity<>(projectStatusNameDto, DefaultHttpHeader.getHeader());

        ResponseEntity<ProjectStatusIdDto> exchange =
                restTemplate.exchange(urlProperties.updateProjectStatus(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectStatusId);
        return exchange.getBody();
    }

    public void deleteProjectStatus(int projectStatusId) {
        String url = UriComponentsBuilder.fromUriString(urlProperties.deleteProjectStatus())
                .buildAndExpand(projectStatusId)
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        restTemplate.exchange(url, HttpMethod.DELETE, entity, Void.class);
    }

    public List<GetCommentDto> getComments(Long id) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<GetCommentDto>> exchange =
                restTemplate.exchange(urlProperties.getComments(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, id);
        return exchange.getBody();
    }

    public RespCommentDto postComment(ReqCommentDto reqCommentDto, Long id) {
        HttpEntity<ReqCommentDto> requestEntity = new HttpEntity<>(reqCommentDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespCommentDto> exchange =
                restTemplate.exchange(urlProperties.postComment(),
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, id);
        return exchange.getBody();
    }

    public RespCommentDto putComment(ReqCommentDto reqCommentDto, Long id) {
        HttpEntity<ReqCommentDto> requestEntity = new HttpEntity<>(reqCommentDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespCommentDto> exchange =
                restTemplate.exchange(urlProperties.putComment(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, id);
        return exchange.getBody();
    }

    public Response deleteComment(Long id) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());
        ResponseEntity<Response> exchange =
                restTemplate.exchange(urlProperties.deleteComment(),
                        HttpMethod.DELETE,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, id);
        return exchange.getBody();
    }

    public List<RespCommentMentionDto> getCommentMentions(Long commentId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<RespCommentMentionDto>> exchange =
                restTemplate.exchange(urlProperties.getComments(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, commentId);
        return exchange.getBody();
    }

    public Response createCommentMention(Long commentId, ReqCommentMentionDto reqCommentMentionDto) {
        HttpEntity<ReqCommentMentionDto> requestEntity = new HttpEntity<>(reqCommentMentionDto, DefaultHttpHeader.getHeader());

        ResponseEntity<Response> exchange =
                restTemplate.exchange(urlProperties.createCommentMention(),
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, commentId);
        return exchange.getBody();
    }

    public Response modifyCommentMention(Long commentId, ReqCommentMentionDto reqCommentMentionDto) {
        HttpEntity<ReqCommentMentionDto> requestEntity = new HttpEntity<>(reqCommentMentionDto, DefaultHttpHeader.getHeader());

        ResponseEntity<Response> exchange =
                restTemplate.exchange(urlProperties.modifyCommentMention(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, commentId);
        return exchange.getBody();
    }

    public Response deleteCommentMention(Long commentId, ReqCommentMentionDto reqCommentMentionDto) {
        HttpEntity<ReqCommentMentionDto> requestEntity = new HttpEntity<>(reqCommentMentionDto, DefaultHttpHeader.getHeader());
        ResponseEntity<Response> exchange =
                restTemplate.exchange(urlProperties.deleteCommentMention(),
                        HttpMethod.DELETE,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, commentId);
        return exchange.getBody();
    }
}




