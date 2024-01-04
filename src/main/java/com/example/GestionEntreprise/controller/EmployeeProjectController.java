package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.dtos.EmployeeProjectDto;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.EmployeeProject;
import com.example.GestionEntreprise.service.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-projects")
public class EmployeeProjectController {

    @Autowired
    private EmployeeProjectService employeeProjectService;

    // Endpoint pour obtenir toutes les affectations employé-projet
    @GetMapping
    public List<EmployeeProjectDto> getAllEmployeeProjects() {
        return employeeProjectService.getAllProjectsEmployees();
    }

    // Autres endpoints pour POST, PUT, DELETE, etc.

    @PostMapping
    public EmployeeProjectDto addEmployeeToProject(@RequestParam Long employeeId, @RequestParam Long projectId, @RequestParam String role) {
        return employeeProjectService.assignEmployeeToProject(employeeId, projectId, role);
    }

    @PutMapping("/{id}")
    public EmployeeProjectDto updateEmployeeProject(@PathVariable Long id, @RequestParam String role) {
        return employeeProjectService.updateRole(id, role);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeFromProject(@PathVariable Long id) {
        employeeProjectService.unassignEmployeeFromProject(id);
    }

    @GetMapping("/available-employees")
    public List<Employee> getAvailableEmployeesForProject() {
        return employeeProjectService.getAvailableEmployeesForProject();
    }
}
