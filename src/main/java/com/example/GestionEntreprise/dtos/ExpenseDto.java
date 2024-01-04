package com.example.GestionEntreprise.dtos;

import java.math.BigDecimal;

public class ExpenseDto {
    private Long expenseID;
    private BigDecimal amount;
    private String description;
    private String expenseType;
    private Long projectId;

    public ExpenseDto() {
    }

    public ExpenseDto(BigDecimal amount, String description, String expenseType, Long projectId) {
        this.amount = amount;
        this.description = description;
        this.expenseType = expenseType;
        this.projectId = projectId;
    }

    public void setExpenseID(Long expenseID) {
        this.expenseID = expenseID;
    }

    public Long getExpenseID() {
        return expenseID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
