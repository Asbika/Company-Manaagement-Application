package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.model.EmployeeProject;
import com.example.GestionEntreprise.repository.EmployeeProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProjectService {

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    public List<EmployeeProject> findAll() {
        return employeeProjectRepository.findAll();
    }

    // Autres méthodes métier pour EmployeeProject
}
