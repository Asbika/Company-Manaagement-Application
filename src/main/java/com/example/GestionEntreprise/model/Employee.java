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
    private String gender;
    private LocalDate dateOfBirth;
    private String cnss;
    private String rib;
    private String bankName;
    private String cin;
    private String companyProfile;
    @Lob
    private String cv;
    private LocalDate hireDate;
    private BigDecimal salary;
    private String contractType;
    private Integer contractDuration;
    private String employeeStatus;

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

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCnss() {
        return cnss;
    }

    public String getRib() {
        return rib;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCin() {
        return cin;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public String getCv() {
        return cv;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getContractType() {
        return contractType;
    }

    public Integer getContractDuration() {
        return contractDuration;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }



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

    // Constructeur par défaut et autres méthodes si nécessaire

    public Employee() {
    }

    
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    // Ajoutez ici d'autres méthodes utilitaires si nécessaire
}
