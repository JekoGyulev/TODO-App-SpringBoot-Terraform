package com.example.todoappterraform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Table(name = "tasks")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;
    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;

}
