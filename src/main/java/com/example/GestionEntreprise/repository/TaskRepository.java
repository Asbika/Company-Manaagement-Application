package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Méthodes personnalisées si nécessaire
}
