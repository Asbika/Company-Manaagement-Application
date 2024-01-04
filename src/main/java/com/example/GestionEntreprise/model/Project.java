package com.example.GestionEntreprise.model;


import com.example.GestionEntreprise.enums.ProjectStatus;
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
    @ManyToOne
    private Employee owner;
    @Lob
    private String description;
    private ProjectStatus projectStatus;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<ProjectPhase> phases = new HashSet<>();

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Expense> expenses = new HashSet<>();

    public Project() {
    }

    // Ajoutez ici les getters, setters et les méthodes utilitaires


    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    public Long getProjectID() {
        return projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Set<ProjectPhase> getPhases() {
        return phases;
    }

    public void setPhases(Set<ProjectPhase> phases) {
        this.phases = phases;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }
}
