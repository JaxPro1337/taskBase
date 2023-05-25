package com.example.taskbase.service.impl;

import com.example.taskbase.exception.NotFountCategory;
import com.example.taskbase.models.entity.Categories;
import com.example.taskbase.repository.CategoryRepo;
import com.example.taskbase.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoryRepo categoryRepo;
    @Override
    public Categories findById(Long categoriesId) {
        Optional<Categories> categories = categoryRepo.findById(categoriesId);
        if (categories.isEmpty()){
            log.error(String.format("Category with id: %s not found",categoriesId));
            throw new NotFountCategory(String.format("Category with id: %s not found",categoriesId));
        }else {
            return categories.get();
        }


    }
}
