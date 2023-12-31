package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Endpoint pour obtenir tous les projets
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.
}
