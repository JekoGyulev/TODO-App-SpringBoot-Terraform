package com.example.todoappterraform.service;

import com.example.todoappterraform.model.Task;
import com.example.todoappterraform.web.dto.AddTaskRequest;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<Task> getAllTodoTasks();

    Task addTask(AddTaskRequest addTaskRequest);

    void deleteTask(UUID id);

    Task toggleComplete(UUID id);
}
