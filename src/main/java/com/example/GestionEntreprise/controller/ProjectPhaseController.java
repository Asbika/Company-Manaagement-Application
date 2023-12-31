package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.model.ProjectPhase;
import com.example.GestionEntreprise.service.ProjectPhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-phases")
public class ProjectPhaseController {

    @Autowired
    private ProjectPhaseService projectPhaseService;

    // Endpoint pour obtenir toutes les phases de projet
    @GetMapping
    public List<ProjectPhase> getAllProjectPhases() {
        return projectPhaseService.findAll();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.
}
