package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.EmployeeProject;
import com.example.GestionEntreprise.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {
    // Méthodes personnalisées si nécessaire
    Boolean existsByEmployeeAndProject(Employee employee, Project project);
}
