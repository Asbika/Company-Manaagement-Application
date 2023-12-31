package com.example.GestionEntreprise.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payrollID;

    private BigDecimal amount;
    private LocalDate payDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeID")
    private Employee employee;

    public Payroll() {
    }

    // Ajoutez ici les getters, setters et méthodes utilitaires
}
