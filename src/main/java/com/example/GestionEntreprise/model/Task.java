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

    // Méthodes utilitaires si nécessaire
}
