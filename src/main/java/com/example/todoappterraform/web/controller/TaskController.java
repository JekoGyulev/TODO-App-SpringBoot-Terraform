package com.example.todoappterraform.web.controller;

import com.example.todoappterraform.model.Task;
import com.example.todoappterraform.service.TaskService;
import com.example.todoappterraform.web.dto.AddTaskRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;


@Controller
@RequestMapping("/")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("tasks", this.taskService.getAllTodoTasks());
        modelAndView.addObject("addTaskRequest", new AddTaskRequest());

        return modelAndView;
    }

    @GetMapping("/tasks/{id}")
    public ModelAndView getTaskDetailsPage(@PathVariable UUID id) {

        Task task = this.taskService.getTaskById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("task-details");
        modelAndView.addObject("task", task);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView addTask(@Valid AddTaskRequest addTaskRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");
            modelAndView.addObject("tasks", this.taskService.getAllTodoTasks());

            return modelAndView;
        }

        this.taskService.addTask(addTaskRequest);

        return new ModelAndView("redirect:/");
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable UUID id) {
        this.taskService.deleteTask(id);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String toggleComplete(@PathVariable UUID id) {
        this.taskService.toggleComplete(id);
        return "redirect:/";
    }









}
