package com.example.GestionEntreprise.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectID;

    private String projectName;
    private BigDecimal budget;
    private BigDecimal amountPaid;
    private LocalDate creationDate;
    private String projectType;
    private String owner;
    @Lob
    private String description;
    private String projectStatus;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProjectPhase> phases = new HashSet<>();

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Expense> expenses = new HashSet<>();

    public Project() {
    }

    // Ajoutez ici les getters, setters et les méthodes utilitaires
}
