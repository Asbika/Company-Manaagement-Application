package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.dtos.ProjectPhaseDto;
import com.example.GestionEntreprise.dtos.TaskDto;
import com.example.GestionEntreprise.model.ProjectPhase;
import com.example.GestionEntreprise.service.ProjectPhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/project-phases")
public class ProjectPhaseController {

    private ProjectPhaseService projectPhaseService;

    @Autowired
    public ProjectPhaseController(ProjectPhaseService projectPhaseService) {
        this.projectPhaseService = projectPhaseService;
    }

    // Endpoint pour obtenir toutes les phases de projet
    @GetMapping
    public List<ProjectPhaseDto> getAllProjectPhases() {
        return projectPhaseService.getAllProjectPhases();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.

    @PostMapping
    public ProjectPhaseDto addProjectPhase(@RequestBody ProjectPhaseDto projectPhaseDto) {
        return projectPhaseService.createProjectPhase(projectPhaseDto);
    }

    @PutMapping("/{projectPhaseId}")
    public ProjectPhaseDto updateProjectPhase(@PathVariable Long projectPhaseId, @RequestBody ProjectPhaseDto projectPhaseDto) {
        projectPhaseDto.setPhaseID(projectPhaseId);
        return projectPhaseService.updateProjectPhase(projectPhaseDto);
    }

    @DeleteMapping("/{projectPhaseId}")
    public void deleteProjectPhase(@PathVariable Long projectPhaseId) {
        projectPhaseService.deleteProjectPhase(projectPhaseId);
    }

    @GetMapping("/{projectPhaseId}/phase-by-id")
    public ProjectPhaseDto getProjectPhaseById(@PathVariable Long projectPhaseId) {
        return projectPhaseService.getProjectPhaseById(projectPhaseId);
    }

    @GetMapping("/{projectId}/phases-by-project-id")
    public List<ProjectPhaseDto> getProjectPhasesByProjectId(@PathVariable Long projectId) {
        return projectPhaseService.getPhasesByProject(projectId);
    }

    @GetMapping("/{phaseId}/calcul-phase-duration")
    public int calculPhaseDuration(@PathVariable Long phaseId) {
        return projectPhaseService.calculatePhaseDuration(phaseId);
    }

    @PutMapping("/{phaseId}/update-tasks-in-phase")
    public ProjectPhaseDto updateTasksInPhase(@PathVariable Long phaseId, @RequestBody Set<TaskDto> taskDtos) {
        return projectPhaseService.updateTasksInPhase(phaseId, taskDtos);
    }

    @DeleteMapping("/{phaseId}/delete-tasks-in-phase")
    public void deleteTasksInPhase(@PathVariable Long phaseId, @RequestParam Set<Long> tasksId) {
        projectPhaseService.deleteTasksInPhase(phaseId, tasksId);
    }

}
