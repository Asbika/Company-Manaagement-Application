package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {
    // Méthodes personnalisées si nécessaire
}
