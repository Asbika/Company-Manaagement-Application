package com.example.GestionEntreprise.dtos;

import java.time.LocalDate;
import java.util.Set;

public class ProjectPhaseDto {
    private Long phaseID;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long projectId;

    private Set<Long> tasksId;

    public ProjectPhaseDto() {
    }

    public ProjectPhaseDto(String description, LocalDate startDate, LocalDate endDate, Long projectId, Set<Long> tasksId) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectId = projectId;
        this.tasksId = tasksId;
    }

    public void setPhaseID(Long phaseID) {
        this.phaseID = phaseID;
    }

    public Long getPhaseID() {
        return phaseID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Set<Long> getTasksId() {
        return tasksId;
    }

    public void setTasksId(Set<Long> tasksId) {
        this.tasksId = tasksId;
    }
}
