package com.example.GestionEntreprise.dtos;

public class EmployeeProjectDto {

    private Long id;
    private Long employeeId;
    private Long projectId;
    private String role;

    public EmployeeProjectDto() {
    }

    public EmployeeProjectDto(Long employeeId, Long projectId, String role) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
