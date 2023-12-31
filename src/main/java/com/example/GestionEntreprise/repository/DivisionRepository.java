package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long> {
    // Méthodes personnalisées si nécessaire
}
