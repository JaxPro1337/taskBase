package com.example.taskbase.repository;

import com.example.taskbase.models.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {


    List<Task> findAllByUserId(Long userId);
}
