package com.example.todoappterraform.service;

import com.example.todoappterraform.model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<Task> getAllTodoTasks();

    Task saveTask(Task task);

    void deleteTask(UUID id);

    Task toggleComplete(UUID id);
}
