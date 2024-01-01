package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.EmployeeProject;
import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.repository.EmployeeProjectRepository;
import com.example.GestionEntreprise.repository.EmployeeRepository;
import com.example.GestionEntreprise.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeProjectService {

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeProject> findAll() {
        return employeeProjectRepository.findAll();
    }

    // Autres méthodes métier pour EmployeeProject

    public void removeEmployeeFromProject(Long projectId, Long employeeId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        project.getEmployees().remove(employee);
        projectRepository.save(project);
    }

    /*public List<Employee> getAvailableEmployeesForProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        Set<Employee> assignedEmployees = employeeProjectRepository.findByProject(project);
        List<Employee> employees = employeeRepository.findAll();
        List<Employee> availabelEmployees = employees.stream()
                .filter(employee -> assignedEmployees.stream()
                        .noneMatch(ep -> ep.getEmployeeID().equals(employee.getEmployeeID())))
                .collect(Collectors.toList());
        return availabelEmployees;
    }*/


}
