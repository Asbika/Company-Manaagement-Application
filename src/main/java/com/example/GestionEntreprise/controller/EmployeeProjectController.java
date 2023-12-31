package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.model.EmployeeProject;
import com.example.GestionEntreprise.service.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-projects")
public class EmployeeProjectController {

    @Autowired
    private EmployeeProjectService employeeProjectService;

    // Endpoint pour obtenir toutes les affectations employé-projet
    @GetMapping
    public List<EmployeeProject> getAllEmployeeProjects() {
        return employeeProjectService.findAll();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.
}
