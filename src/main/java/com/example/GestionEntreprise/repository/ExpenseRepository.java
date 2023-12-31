package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Méthodes personnalisées si nécessaire
}
