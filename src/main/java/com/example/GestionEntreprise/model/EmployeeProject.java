package com.example.GestionEntreprise.model;


import jakarta.persistence.*;

@Entity
@Table(name = "employee_project")
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeID")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectID")
    private Project project;

    private String role;

    public EmployeeProject() {
    }

    // Getters et setters
}
