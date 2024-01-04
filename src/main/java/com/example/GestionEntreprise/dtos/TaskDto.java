package com.example.GestionEntreprise.dtos;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class TaskDto {

    private Long taskID;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long responsibleId;
    private Long projectPhaseId;

    public TaskDto() {
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setResponsibleId(Long responsibleId) {
        this.responsibleId = responsibleId;
    }

    public void setProjectPhaseId(Long projectPhaseId) {
        this.projectPhaseId = projectPhaseId;
    }

    public Long getTaskID() {
        return taskID;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getResponsibleId() {
        return responsibleId;
    }

    public Long getProjectPhaseId() {
        return projectPhaseId;
    }
}
