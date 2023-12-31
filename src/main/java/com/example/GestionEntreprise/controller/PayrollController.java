package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.model.Payroll;
import com.example.GestionEntreprise.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payrolls")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    // Endpoint pour obtenir tous les bulletins de paie
    @GetMapping
    public List<Payroll> getAllPayrolls() {
        return payrollService.findAll();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.
}
