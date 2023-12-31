package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Méthodes personnalisées si nécessaire
}
