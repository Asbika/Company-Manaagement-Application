package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.model.Expense;
import com.example.GestionEntreprise.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    // Autres méthodes métier pour Expense
}
