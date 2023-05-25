package com.example.taskbase.models.entity;

import com.example.taskbase.models.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String description;
    @JoinColumn(name = "created_date")
    LocalDateTime createdDate;
    @JoinColumn(name = "updated_date")
    LocalDateTime updatedDate;
    Status status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User userId;
    @ManyToOne
    @JoinColumn(name = "categories_id")
    Categories categoriesId;

    @PrePersist
    public void preCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }

}
