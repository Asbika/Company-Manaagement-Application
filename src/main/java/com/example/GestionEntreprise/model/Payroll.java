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

    public void setPayrollID(Long payrollID) {
        this.payrollID = payrollID;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getPayrollID() {
        return payrollID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeID")
    private Employee employee;

    public Payroll() {
    }

    public Employee getEmployee() {
        return employee;
    }
    // Ajoutez ici les getters, setters et méthodes utilitaires
}
