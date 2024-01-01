package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.enums.ProjectStatus;
import com.example.GestionEntreprise.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Méthodes personnalisées si nécessaire
    List<Project> findByProjectStatus(ProjectStatus projectStatus);
    List<Project> findByProjectType(String type);
}
