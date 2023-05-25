package com.example.taskbase.controller;

import com.example.taskbase.models.Dto.CreateTaskDto;
import com.example.taskbase.models.Dto.UpdateTaskDto;
import com.example.taskbase.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task/")
@Slf4j
public class TaskController {
    private final TaskService taskService;

    @PostMapping("create")
    public ResponseEntity<?> createTask (@RequestBody CreateTaskDto createTaskDto){

        return ResponseEntity.ok(taskService.createTask(createTaskDto));
    }

    @GetMapping("list")
    public ResponseEntity<?> getAllTasks (@RequestParam Long userId){
        return ResponseEntity.ok(taskService.getAllTasks(userId));
    }

    @PutMapping("update")
    public ResponseEntity<?> updateTask (@RequestBody UpdateTaskDto updateTaskDto,
                                         @RequestParam Long userId){
        return ResponseEntity.ok(taskService.updateTask(updateTaskDto, userId));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteTask(@RequestParam Long taskId, @RequestParam Long userId){
        return ResponseEntity.ok(taskService.deleteTask(taskId, userId));
    }







}



