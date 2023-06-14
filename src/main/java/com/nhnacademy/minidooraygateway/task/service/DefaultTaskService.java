package com.nhnacademy.minidooraygateway.task.service;

import com.nhnacademy.minidooraygateway.task.adaptor.TaskAdaptor;
import com.nhnacademy.minidooraygateway.task.dto.task.GetTaskDto;
import com.nhnacademy.minidooraygateway.task.dto.task.ReqTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultTaskService implements TaskService {
    private final TaskAdaptor taskAdaptor;

    @Override
    public List<GetTaskDto> getTasks(Long projectId) {
        return taskAdaptor.getTasks(projectId);
    }

    @Override
    public void createTask(ReqTaskDto reqTaskDto, Long projectId) {
        taskAdaptor.createTask(reqTaskDto, projectId);
    }
}
