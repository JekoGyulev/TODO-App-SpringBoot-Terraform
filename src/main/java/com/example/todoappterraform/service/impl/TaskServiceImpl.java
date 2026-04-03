package com.example.todoappterraform.service.impl;

import com.example.todoappterraform.model.Task;
import com.example.todoappterraform.repository.TaskRepository;
import com.example.todoappterraform.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return this.taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public void deleteTask(UUID id) {
        this.taskRepository.deleteById(id);
    }

    @Override
    public Task toggleComplete(UUID id) {

        Optional<Task> optionalT = this.taskRepository.findById(id);

        if (optionalT.isEmpty()) {
            throw new IllegalArgumentException("Task with such ID does not exist");
        }

        Task task = optionalT.get();

        task.setCompleted(!task.isCompleted());

        return this.taskRepository.save(task);
    }
}
