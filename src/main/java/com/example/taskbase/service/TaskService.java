package com.example.taskbase.service;

import com.example.taskbase.models.Dto.CreateTaskDto;
import com.example.taskbase.models.Dto.UpdateTaskDto;
import com.example.taskbase.models.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(CreateTaskDto taskDto);

    List<Task> getAllTasks(Long userId);

    Task updateTask(UpdateTaskDto updateTaskDto, Long userId);

    Boolean deleteTask(Long taskId, Long userId);
}
