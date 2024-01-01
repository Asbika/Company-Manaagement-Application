package com.example.GestionEntreprise.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PayrollDto {

    public PayrollDto(Long payrollID, BigDecimal amount, LocalDate payDate, Long employeeId) {
        this.payrollID = payrollID;
        this.amount = amount;
        this.payDate = payDate;
        this.employeeId = employeeId;
    }

    public PayrollDto() {
    }

    private Long payrollID;
    private BigDecimal amount;
    private LocalDate payDate;
    private Long employeeId;



    public Long getPayrollID() {
        return payrollID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setPayrollID(Long payrollID) {
        this.payrollID = payrollID;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
