package com.nhnacademy.minidooraygateway.task.service;

import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
import com.nhnacademy.minidooraygateway.task.dto.task.ReqTaskDto;

import java.util.List;

public interface TaskService {
    List<GetTaskDto> getTasks(Long projectId);

    void createTask(ReqTaskDto reqTaskDto, Long projectId);
}
