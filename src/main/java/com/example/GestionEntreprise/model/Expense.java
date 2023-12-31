package com.example.GestionEntreprise.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseID;

    private BigDecimal amount;
    private String description;
    private String expenseType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectID")
    private Project project;

    public Expense() {
    }

    // Ajoutez ici les getters, setters et méthodes utilitaires
}
