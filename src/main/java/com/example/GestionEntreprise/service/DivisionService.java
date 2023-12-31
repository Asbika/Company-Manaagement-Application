package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.model.Division;
import com.example.GestionEntreprise.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    // Autres méthodes métier pour Division
}
