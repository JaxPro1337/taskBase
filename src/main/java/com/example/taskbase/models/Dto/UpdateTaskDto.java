package com.example.taskbase.models.Dto;

import com.example.taskbase.models.entity.Categories;
import com.example.taskbase.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateTaskDto {


    Long id;
    String title;
    String description;
    @JsonProperty("categories_id")
    Long categoriesId;


}
