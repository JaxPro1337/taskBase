package com.example.taskbase.service;

import com.example.taskbase.models.entity.Categories;

public interface CategoriesService {
    Categories findById(Long categoriesId);
}
