package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.Expense;
import com.example.GestionEntreprise.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Méthodes personnalisées si nécessaire
    List<Expense> findExpensesByProject(Project project);
}
