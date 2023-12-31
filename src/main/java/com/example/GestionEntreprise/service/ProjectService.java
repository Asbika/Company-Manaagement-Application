package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    // Autres méthodes métier pour Project
}
