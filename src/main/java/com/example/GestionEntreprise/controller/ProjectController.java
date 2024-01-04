package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.dtos.EmployeeDto;
import com.example.GestionEntreprise.dtos.ProjectDto;
import com.example.GestionEntreprise.enums.ProjectStatus;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Endpoint pour obtenir tous les projets
    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.getProjects();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.

    @PostMapping
    public ProjectDto addProject(@RequestBody ProjectDto projectDto) {
        return projectService.createProject(projectDto);
    }

    @GetMapping("/{projectId}")
    public ProjectDto getProjectById(@PathVariable Long projectId) {
        return projectService.getProjectById(projectId);
    }

    @PutMapping("/{projectId}")
    public ProjectDto updateProject(@PathVariable Long projectId, @RequestBody ProjectDto projectDto) {
        projectDto.setProjectID(projectId);
        return projectService.updateProject(projectDto);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
    }

    @GetMapping("/{projectId}/employees-by-project")
    public Set<EmployeeDto> getEmployeesByProject(@PathVariable Long projectId) {
        return projectService.getEmployeesByProject(projectId);
    }

    @GetMapping("/{status}/projects-by-status")
    public List<ProjectDto> getProjectsByStatus(@PathVariable ProjectStatus status) {
        return projectService.getProjectsByStatus(status);
    }

    @GetMapping("/{type}/projects-by-type")
    public List<ProjectDto> getProjectsByType(@PathVariable String type) {
        return projectService.getProjectsByType(type);
    }

    @GetMapping("/{projectId}/remaining-budget")
    public BigDecimal calculRemainingBudget(@PathVariable Long projectId) {
        return projectService.calculRemainingBudget(projectId);
    }


    @PutMapping("/{projectId}/mark-completed")
    public void markProjectAsCompleted(@PathVariable Long projectId) {
        projectService.markProjectAsCompleted(projectId);
    }

    @GetMapping("/projects-canceled")
    public List<ProjectDto> getCanceledProjects() {
        return projectService.getCanceledProjects();
    }

    @GetMapping("/projects-completed")
    public List<ProjectDto> getCompletedProjects() {
        return projectService.getCompletedProjects();
    }

}
