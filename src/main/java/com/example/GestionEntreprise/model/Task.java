package com.example.GestionEntreprise.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskID;

    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsibleID")
    private Employee responsible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phaseID")
    private ProjectPhase projectPhase;

    // Constructeur par défaut et autres méthodes si nécessaire

    public Task() {
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

    public void setResponsible(Employee responsible) {
        this.responsible = responsible;
    }

    public void setProjectPhase(ProjectPhase projectPhase) {
        this.projectPhase = projectPhase;
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

    public Employee getResponsible() {
        return responsible;
    }

    public ProjectPhase getProjectPhase() {
        return projectPhase;
    }

    // Méthodes utilitaires si nécessaire
}
