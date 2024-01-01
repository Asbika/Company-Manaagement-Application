package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.enums.ProjectStatus;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.EmployeeProject;
import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.repository.EmployeeProjectRepository;
import com.example.GestionEntreprise.repository.EmployeeRepository;
import com.example.GestionEntreprise.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    // Autres méthodes métier pour Project

    public Project createProject(Project project) {
        if (project.getProjectID() != null) {
            throw new IllegalArgumentException("Cannot create a project with this id");
        }

        return projectRepository.save(project);
    }

    public void updateProject(Long projectId, Project project) {
        Project oldProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        oldProject.setProjectName(project.getProjectName());
        oldProject.setBudget(project.getBudget());
        oldProject.setAmountPaid(project.getAmountPaid());
        oldProject.setCreationDate(project.getCreationDate());
        oldProject.setProjectType(project.getProjectType());
        oldProject.setOwner(project.getOwner());
        oldProject.setDescription(project.getDescription());
        oldProject.setProjectStatus(project.getProjectStatus());
        oldProject.setPhases(project.getPhases());
        oldProject.setEmployees(project.getEmployees());
        oldProject.setExpenses(project.getExpenses());
        projectRepository.save(oldProject);
    }

    public void deleteProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        projectRepository.deleteById(projectId);
    }

    public Project getProjectById(Long projectId) {

        return projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
    }

    public Set<Employee> getEmployeesByProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project with ID " + projectId + " not found"));
        return project.getEmployees();
    }

    public List<Project> getProjectsByStatus(ProjectStatus status) {
        return projectRepository.findByProjectStatus(status);
    }

    public List<Project> getProjectsByType(String type) {
        return projectRepository.findByProjectType(type);
    }

    public BigDecimal calculRemainingBudget(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        BigDecimal remainBudget = project.getBudget().subtract(project.getAmountPaid());
        return remainBudget;
    }

    public void markProjectAsCompleted(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        project.setProjectStatus(ProjectStatus.COMPLETED);
        projectRepository.save(project);
    }

    public List<Project> getCanceledProjects() {
        List<Project> allProjects = projectRepository.findAll();
        List<Project> canceledProjects = allProjects.stream()
                .filter(project -> project.getProjectStatus().equals(ProjectStatus.CANCELED))
                .collect(Collectors.toList());
        return canceledProjects;
    }

    public List<Project> getCompletedProjects() {
        List<Project> allProjects = projectRepository.findAll();
        List<Project> completedProjects = allProjects.stream()
                .filter(project -> project.getProjectStatus().equals(ProjectStatus.COMPLETED))
                .collect(Collectors.toList());
        return completedProjects;
    }


}
