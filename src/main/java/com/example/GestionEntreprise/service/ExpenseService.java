package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.dtos.ExpenseDto;
import com.example.GestionEntreprise.mappers.ExpenseMapper;
import com.example.GestionEntreprise.model.Expense;
import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.repository.ExpenseRepository;
import com.example.GestionEntreprise.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ExpenseMapper expenseMapper;

    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .filter(expense -> expense.getProject() != null)
                .map(expense -> expenseMapper.fromExpense(expense))
                .collect(Collectors.toList());
    }

    // Autres méthodes métier pour Expense

    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.fromExpenseDto(expenseDto);
        Expense savedExpense = expenseRepository.save(expense);
        return expenseMapper.fromExpense(savedExpense);
    }

    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new IllegalArgumentException("Expense not found"));
        expense.setAmount(expenseDto.getAmount());
        expense.setExpenseType(expenseDto.getExpenseType());
        expense.setDescription(expenseDto.getDescription());

        if (expenseDto.getProjectId() == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
        expense.setProject(projectRepository.findById(expenseDto.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("Project not found")));
        Expense updatedExpense = expenseRepository.save(expense);
        return expenseMapper.fromExpense(updatedExpense);
    }

    public void deleteExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new IllegalArgumentException("Expense not found"));

        expenseRepository.delete(expense);
    }

    public ExpenseDto getExpenseById(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new IllegalArgumentException("Expense not found"));
        return expenseMapper.fromExpense(expense);
    }

    public List<ExpenseDto> getExpensesByProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        List<Expense> expenses = expenseRepository.findExpensesByProject(project);
        return expenses.stream()
                .map(expense -> expenseMapper.fromExpense(expense))
                .collect(Collectors.toList());
    }

    public BigDecimal calculateTotalExpenseCost(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        List<Expense> expenses = expenseRepository.findExpensesByProject(project);

        BigDecimal totalCost = expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalCost;
    }


}
