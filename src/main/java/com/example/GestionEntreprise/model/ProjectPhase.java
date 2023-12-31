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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectID")
    private Project project;

    @OneToMany(mappedBy = "projectPhase", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Task> tasks = new HashSet<>();

    public ProjectPhase() {
    }

    // Ajoutez ici les getters, setters et méthodes utilitaires
}
