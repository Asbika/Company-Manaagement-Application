package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.model.Task;
import com.example.GestionEntreprise.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Endpoint pour obtenir toutes les tâches
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.
}
