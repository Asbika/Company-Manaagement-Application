package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.dtos.ExpenseDto;
import com.example.GestionEntreprise.model.Expense;
import com.example.GestionEntreprise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Endpoint pour obtenir toutes les dépenses
    @GetMapping
    public List<ExpenseDto> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.

    @PostMapping
    public ExpenseDto addExpense(@RequestBody ExpenseDto expenseDto) {
        return expenseService.createExpense(expenseDto);
    }

    @PutMapping("/{expenseId}")
    public ExpenseDto updateExpense(@PathVariable Long expenseId, @RequestBody ExpenseDto expenseDto) {
        return expenseService.updateExpense(expenseId, expenseDto);
    }

    @DeleteMapping("/{expenseId}")
    public void deleteExpense(@PathVariable Long expenseId) {
        expenseService.deleteExpense(expenseId);
    }

    @GetMapping("/{expenseId}/expense-by-id")
    public ExpenseDto getExpenseById(@PathVariable Long expenseId) {
        return expenseService.getExpenseById(expenseId);
    }

    @GetMapping("/{projectId}/expenses-by-project")
    public List<ExpenseDto> getExpensesByProject(@PathVariable Long projectId) {
        return expenseService.getExpensesByProject(projectId);
    }

    @GetMapping("/{projectId}/calcul-total-exepense-cost")
    public BigDecimal calculateTotalExpenseCost(@PathVariable Long projectId) {
        return expenseService.calculateTotalExpenseCost(projectId);
    }

}
