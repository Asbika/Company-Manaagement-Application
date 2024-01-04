package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.model.ProjectPhase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectPhaseRepository extends JpaRepository<ProjectPhase, Long> {
    // Méthodes personnalisées si nécessaire
    List<ProjectPhase> findProjectPhaseByProject(Project project);
}
