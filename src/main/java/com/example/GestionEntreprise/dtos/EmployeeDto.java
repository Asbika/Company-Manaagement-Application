package com.example.GestionEntreprise.dtos;

import jakarta.persistence.Lob;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class EmployeeDto {
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
    private String cv;
    private LocalDate hireDate;
    private BigDecimal salary;
    private String contractType;
    private Integer contractDuration;
    private String employeeStatus;
    private Long divisionId;
    private Set<Long> tasksId;
    private Set<Long> projectsId;
    private Set<Long> payrollsId;

    public EmployeeDto() {
    }

    public EmployeeDto(String firstName, String lastName, String email, String phoneNumber, String gender, LocalDate dateOfBirth, String cnss, String rib, String bankName, String cin, String companyProfile, String cv, LocalDate hireDate, BigDecimal salary, String contractType, Integer contractDuration, String employeeStatus, Long divisionId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.cnss = cnss;
        this.rib = rib;
        this.bankName = bankName;
        this.cin = cin;
        this.companyProfile = companyProfile;
        this.cv = cv;
        this.hireDate = hireDate;
        this.salary = salary;
        this.contractType = contractType;
        this.contractDuration = contractDuration;
        this.employeeStatus = employeeStatus;
        this.divisionId = divisionId;
    }

    public EmployeeDto(String firstName, String lastName, String email, String phoneNumber, String gender, LocalDate dateOfBirth, String cnss, String rib, String bankName, String cin, String companyProfile, String cv, LocalDate hireDate, BigDecimal salary, String contractType, Integer contractDuration, String employeeStatus, Long divisionId, Set<Long> tasksId, Set<Long> projectsId, Set<Long> payrollsId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.cnss = cnss;
        this.rib = rib;
        this.bankName = bankName;
        this.cin = cin;
        this.companyProfile = companyProfile;
        this.cv = cv;
        this.hireDate = hireDate;
        this.salary = salary;
        this.contractType = contractType;
        this.contractDuration = contractDuration;
        this.employeeStatus = employeeStatus;
        this.divisionId = divisionId;
        this.tasksId = tasksId;
        this.projectsId = projectsId;
        this.payrollsId = payrollsId;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Integer getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(Integer contractDuration) {
        this.contractDuration = contractDuration;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public Set<Long> getTasksId() {
        return tasksId;
    }

    public void setTasksId(Set<Long> tasksId) {
        this.tasksId = tasksId;
    }

    public Set<Long> getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(Set<Long> projectsId) {
        this.projectsId = projectsId;
    }

    public Set<Long> getPayrollsId() {
        return payrollsId;
    }

    public void setPayrollsId(Set<Long> payrollsId) {
        this.payrollsId = payrollsId;
    }
}
