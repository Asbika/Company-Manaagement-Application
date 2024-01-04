package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.dtos.EmployeeProjectDto;
import com.example.GestionEntreprise.mappers.EmployeeProjectMapper;
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
    @Autowired
    private EmployeeProjectMapper employeeProjectMapper;

    public List<EmployeeProjectDto> getAllProjectsEmployees() {
        List<EmployeeProject> employeesProjects = employeeProjectRepository.findAll();
        return employeesProjects.stream()
                .map(employeeProject -> employeeProjectMapper.fromEmployeeProject(employeeProject))
                .collect(Collectors.toList());
    }

    // Autres méthodes métier pour EmployeeProject

    public EmployeeProjectDto assignEmployeeToProject(Long employeeId, Long projectId, String role) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        if (employeeProjectRepository.existsByEmployeeAndProject(employee, project)) {
            throw new IllegalArgumentException("Employee is already assigned to the project");
        }

        EmployeeProject employeeProject = new EmployeeProject();
        employeeProject.setEmployee(employee);
        employeeProject.setProject(project);
        employeeProject.setRole(role);
        EmployeeProject savedEmployeeProject = employeeProjectRepository.save(employeeProject);
        return employeeProjectMapper.fromEmployeeProject(savedEmployeeProject);
    }

    /*public void removeEmployeeFromProject(Long projectId, Long employeeId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        project.getEmployees().remove(employee);
        projectRepository.save(project);
    }*/

    public List<Employee> getAvailableEmployeesForProject() {
        return employeeRepository.findAvailableEmployeesForProject();
    }


    public EmployeeProjectDto updateRole(Long id, String role) {
        EmployeeProject employeeProject = employeeProjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("EmployeeProject not found"));

        employeeProject.setRole(role);
        EmployeeProject updatedEmployeeProject = employeeProjectRepository.save(employeeProject);
        return employeeProjectMapper.fromEmployeeProject(updatedEmployeeProject);
    }

    public void unassignEmployeeFromProject(Long id) {
        EmployeeProject employeeProject = employeeProjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("EmployeeProject not found"));

        employeeProjectRepository.delete(employeeProject);
    }

}
