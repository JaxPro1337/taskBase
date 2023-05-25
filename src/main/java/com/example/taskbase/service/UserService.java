package com.example.taskbase.service;

import com.example.taskbase.models.entity.User;

public interface UserService {
    User findById(Long userId);
}
