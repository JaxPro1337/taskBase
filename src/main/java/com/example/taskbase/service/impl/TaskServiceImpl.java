package com.example.taskbase.service.impl;

import com.example.taskbase.exception.NotEnoughRight;
import com.example.taskbase.exception.NotFountCategory;
import com.example.taskbase.models.Dto.CreateTaskDto;
import com.example.taskbase.models.Dto.UpdateTaskDto;
import com.example.taskbase.models.entity.Categories;
import com.example.taskbase.models.entity.Task;
import com.example.taskbase.models.entity.User;
import com.example.taskbase.models.enums.Status;
import com.example.taskbase.repository.TaskRepo;
import com.example.taskbase.service.CategoriesService;
import com.example.taskbase.service.TaskService;
import com.example.taskbase.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final UserService userService;
    private final CategoriesService categoriesService;

    @Override
    public Task createTask(CreateTaskDto createTaskDto) {
        Task task = Task
                .builder()
                .title(createTaskDto.getTitle())
                .description(createTaskDto.getDescription())
                .status(Status.NEW)
                .userId(userService.findById(createTaskDto.getUserId()))
                .categoriesId(categoriesService.findById(createTaskDto.getCategoriesId()))
                .build();

        return taskRepo.save(task);
    }

    @Override
    public List<Task> getAllTasks(Long userId) {
        return taskRepo.findAllByUserId(userId);
    }

    @Override
    public Task updateTask(UpdateTaskDto updateTaskDto, Long userId) {
        Optional<Task> optionalTask = taskRepo.findById(updateTaskDto.getId());
        if (optionalTask.isEmpty()){
            log.error(String.format("Task with id: %s not found",updateTaskDto.getId()));
            throw new NotFountCategory(String.format("Task with id: %s not found",updateTaskDto.getId()));
        }else {
            Task task = optionalTask.get();
            if (task.getUserId().getId() != userId){
                log.error(String.format("Task with id: %s not enough rights",userId));
                throw new NotEnoughRight(String.format("Task with id: %s not enough rights",userId));
            }else {
                task.setCategoriesId(categoriesService.findById(updateTaskDto.getCategoriesId()));
                task.setDescription(updateTaskDto.getDescription());
                task.setTitle(updateTaskDto.getTitle());
                return taskRepo.save(task);
            }

        }

    }

    @Override
    public Boolean deleteTask(Long taskId, Long userId) {
        Optional<Task> optionalTask = taskRepo.findById(taskId);
        if (optionalTask.isEmpty()){
            log.error(String.format("Task with id: %s not found",taskId));
            throw new NotFountCategory(String.format("Task with id: %s not found",taskId));
        }else {
            Task task = optionalTask.get();
            if (task.getUserId().getId() != userId){
                log.error(String.format("Task with id: %s not enough rights",userId));
                throw new NotEnoughRight(String.format("Task with id: %s not enough rights",userId));
            }else {
                task.setStatus(Status.DELETED);
                return true;
            }
        }

    }
}
