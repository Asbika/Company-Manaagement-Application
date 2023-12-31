package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    // Méthodes personnalisées si nécessaire
}
