package com.nhnacademy.minidooraygateway.task.adaptor;

import com.nhnacademy.minidooraygateway.config.UrlProperties;
import com.nhnacademy.minidooraygateway.task.domain.Project;
import com.nhnacademy.minidooraygateway.task.domain.Response;
import com.nhnacademy.minidooraygateway.task.dto.project.GetProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.ReqProjectDto;
import com.nhnacademy.minidooraygateway.task.dto.project.RespProjectDto;
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
        HttpEntity<ReqProjectDto> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<Response> exchange =
                restTemplate.exchange(urlProperties.deleteProject(),
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

    public List<GetTaskDto> getTags(Long projectId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<GetTaskDto>> exchange =
                restTemplate.exchange(urlProperties.getTags(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
    }

    public List<GetTaskDto> getTagsByTags(Long projectId, Long taskId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<GetTaskDto>> exchange =
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

    public RespTagDto modifyTag(RespTagDto respTagDto, Long projectId, Long tagId) {
        HttpEntity<RespTagDto> requestEntity = new HttpEntity<>(respTagDto, DefaultHttpHeader.getHeader());

        ResponseEntity<RespTagDto> exchange =
                restTemplate.exchange(urlProperties.modifyTag(),
                        HttpMethod.PUT,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId, tagId);
        return exchange.getBody();
    }

    public void deleteTag(Long tagId) {
        String url = UriComponentsBuilder.fromUriString(urlProperties.deleteTag())
                .buildAndExpand(tagId)
                .toUriString();
        restTemplate.delete(url);
    }
}






















