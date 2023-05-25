package com.example.taskbase.models.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateTaskDto {

    String title;
    String description;
    @JsonProperty("categories_id")
    Long categoriesId;
    @JsonProperty("user_id")
    Long userId;

}
