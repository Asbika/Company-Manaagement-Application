package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.model.Expense;
import com.example.GestionEntreprise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Endpoint pour obtenir toutes les dépenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.findAll();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.
}
