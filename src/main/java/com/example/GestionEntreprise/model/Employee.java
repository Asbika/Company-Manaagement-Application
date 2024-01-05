package com.example.GestionEntreprise.model;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeID;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @Lob
    private LocalDate hireDate;
    private BigDecimal salary;
    private String contractType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "divisionID")
    private Division division;

    @OneToMany(mappedBy = "responsible", cascade = CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employeeID"),
            inverseJoinColumns = @JoinColumn(name = "projectID")
    )
    private Set<Project> projects = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Payroll> payrolls = new HashSet<>();


    public Long getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getContractType() {
        return contractType;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Set<Payroll> getPayrolls() {
        return payrolls;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public void setPayrolls(Set<Payroll> payrolls) {
        this.payrolls = payrolls;
    }
}
