package com.example.GestionEntreprise.dtos;

import com.example.GestionEntreprise.model.Division;
import com.example.GestionEntreprise.model.Payroll;
import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.model.Task;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDto {

    private Long employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private BigDecimal salary;
    private String contractType;
    private Set<Task> tasks = new HashSet<>();
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
