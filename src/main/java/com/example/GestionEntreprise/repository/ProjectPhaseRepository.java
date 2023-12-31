package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.ProjectPhase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectPhaseRepository extends JpaRepository<ProjectPhase, Long> {
    // Méthodes personnalisées si nécessaire
}
