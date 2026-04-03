package com.example.todoappterraform.service.impl;

import com.example.todoappterraform.model.Task;
import com.example.todoappterraform.repository.TaskRepository;
import com.example.todoappterraform.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTodoTasks() {
        return List.of();
    }

    @Override
    public Task saveTask(Task task) {
        return null;
    }

    @Override
    public void deleteTask(UUID id) {

    }

    @Override
    public Task toggleComplete(UUID id) {
        return null;
    }
}
