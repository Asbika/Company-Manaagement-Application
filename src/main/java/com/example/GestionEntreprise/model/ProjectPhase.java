package com.example.GestionEntreprise.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project_phase")
public class ProjectPhase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phaseID;

    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public void setPhaseID(Long phaseID) {
        this.phaseID = phaseID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectID")
    private Project project;

    @OneToMany(mappedBy = "projectPhase", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Task> tasks = new HashSet<>();

    public ProjectPhase() {
    }

    public Long getPhaseID() {
        return phaseID;
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

    public Project getProject() {
        return project;
    }

    public Set<Task> getTasks() {
        return tasks;
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

    public void setProject(Project project) {
        this.project = project;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    // Ajoutez ici les getters, setters et méthodes utilitaires
}
