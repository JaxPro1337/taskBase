package com.example.taskbase.service.impl;

import com.example.taskbase.exception.NotFountCategory;
import com.example.taskbase.models.entity.Categories;
import com.example.taskbase.models.entity.User;
import com.example.taskbase.repository.UserRepo;
import com.example.taskbase.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    public final UserRepo userRepo;

    @Override
    public User findById(Long userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isEmpty()){
            log.error(String.format("Category with id: %s not found",userId));
            throw new NotFountCategory(String.format("Category with id: %s not found",userId));
        }else
            return user.get();
    }
}
