package com.example.GestionEntreprise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Ajoutez des attributs au modèle si nécessaire
        return "home"; // Nom du template Thymeleaf sans l'extension '.html'
    }
}
