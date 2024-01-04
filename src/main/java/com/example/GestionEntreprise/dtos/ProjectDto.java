package com.example.GestionEntreprise.dtos;

import com.example.GestionEntreprise.enums.ProjectStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class ProjectDto {
    private Long projectID;
    private String projectName;
    private BigDecimal budget;
    private BigDecimal amountPaid;
    private LocalDate creationDate;
    private String projectType;
    private Long ownerId;
    private String description;
    private ProjectStatus projectStatus;
    private Set<Long> projectPhaseId;
    private Set<Long> employeesId;
    private Set<Long> expensesId;

    public ProjectDto() {
    }

    public ProjectDto(String projectName, BigDecimal budget, BigDecimal amountPaid, LocalDate creationDate, String projectType, Long ownerId, String description, ProjectStatus projectStatus) {
        this.projectName = projectName;
        this.budget = budget;
        this.amountPaid = amountPaid;
        this.creationDate = creationDate;
        this.projectType = projectType;
        this.ownerId = ownerId;
        this.description = description;
        this.projectStatus = projectStatus;
    }

    public ProjectDto(String projectName, BigDecimal budget, BigDecimal amountPaid, LocalDate creationDate, String projectType, Long ownerId, String description, ProjectStatus projectStatus, Set<Long> projectPhaseId, Set<Long> employeesId, Set<Long> expensesId) {
        this.projectName = projectName;
        this.budget = budget;
        this.amountPaid = amountPaid;
        this.creationDate = creationDate;
        this.projectType = projectType;
        this.ownerId = ownerId;
        this.description = description;
        this.projectStatus = projectStatus;
        this.projectPhaseId = projectPhaseId;
        this.employeesId = employeesId;
        this.expensesId = expensesId;
    }

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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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

    public Set<Long> getProjectPhaseId() {
        return projectPhaseId;
    }

    public void setProjectPhaseId(Set<Long> projectPhaseId) {
        this.projectPhaseId = projectPhaseId;
    }

    public Set<Long> getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Set<Long> employeesId) {
        this.employeesId = employeesId;
    }

    public Set<Long> getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(Set<Long> expensesId) {
        this.expensesId = expensesId;
    }
}
