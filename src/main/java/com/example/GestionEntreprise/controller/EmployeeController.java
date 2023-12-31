package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Endpoint pour obtenir tous les employés
    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.
}
