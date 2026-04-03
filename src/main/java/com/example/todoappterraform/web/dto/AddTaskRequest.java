package com.example.todoappterraform.web.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddTaskRequest {

    @NotBlank(message = "Please enter the title of your task")
    @Size(min = 2, max = 30, message = "The title of your task should be between 2 and 30 characters")
    private String title;
    private String description;


}
