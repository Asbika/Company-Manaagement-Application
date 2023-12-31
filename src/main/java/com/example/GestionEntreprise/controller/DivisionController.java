package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.model.Division;
import com.example.GestionEntreprise.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/divisions")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    // Endpoint pour obtenir toutes les divisions
    @GetMapping
    public List<Division> getAllDivisions() {
        return divisionService.findAll();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.
}
