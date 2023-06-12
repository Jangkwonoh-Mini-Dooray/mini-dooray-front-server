package com.nhnacademy.minidooraygateway.task.adaptor;

import com.nhnacademy.minidooraygateway.config.UrlProperties;
import com.nhnacademy.minidooraygateway.task.dto.GetTaskDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.GetMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.ReqMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.milestone.RespMilestoneDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.ReqTagDto;
import com.nhnacademy.minidooraygateway.task.dto.tag.RespTagDto;
import com.nhnacademy.minidooraygateway.util.DefaultHttpHeader;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
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

    // project Id 로 전체 task 조회
    public List<GetTaskDto> getTasks(Long projectId) {
        HttpEntity<String> requestEntity = new HttpEntity<>(DefaultHttpHeader.getHeader());

        ResponseEntity<List<GetTaskDto>> exchange =
                restTemplate.exchange(urlProperties.getTask(),
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<>() {
                        }, projectId);
        return exchange.getBody();
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






















