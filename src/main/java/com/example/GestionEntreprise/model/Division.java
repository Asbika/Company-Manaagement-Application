package com.example.GestionEntreprise.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long divisionID;

    @Column(nullable = false, length = 255)
    private String divisionName;

    // Relation avec Employee (si un employé est le chef de cette division)
    @OneToOne
    @JoinColumn(name = "headID", referencedColumnName = "employeeID")
    private Employee head;

    // Relation avec Employee (employés appartenant à cette division)
    @OneToMany(mappedBy = "division")
    private Set<Employee> employees = new HashSet<>();

    // Constructeurs, getters et setters

    public Division() {
    }

    public Long getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Long divisionID) {
        this.divisionID = divisionID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    // Méthodes utilitaires si nécessaire (comme addEmployee, removeEmployee, etc.)
}
