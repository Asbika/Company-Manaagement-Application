package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.model.ProjectPhase;
import com.example.GestionEntreprise.repository.ProjectPhaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectPhaseService {

    @Autowired
    private ProjectPhaseRepository projectPhaseRepository;

    public List<ProjectPhase> findAll() {
        return projectPhaseRepository.findAll();
    }

    public ProjectPhase findById(Long id){
        return projectPhaseRepository.findById(id).get();
    }

    // Autres méthodes métier pour ProjectPhase
}
