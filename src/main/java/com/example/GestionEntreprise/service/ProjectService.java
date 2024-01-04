package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.dtos.EmployeeDto;
import com.example.GestionEntreprise.dtos.ProjectDto;
import com.example.GestionEntreprise.dtos.ProjectPhaseDto;
import com.example.GestionEntreprise.enums.ProjectStatus;
import com.example.GestionEntreprise.mappers.EmployeeMapper;
import com.example.GestionEntreprise.mappers.ProjectMapper;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.Expense;
import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.model.ProjectPhase;
import com.example.GestionEntreprise.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectPhaseRepository projectPhaseRepository;
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<ProjectDto> getProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDto> projectDtos = projects.stream()
                .map(project -> projectMapper.fromProject(project))
                .collect(Collectors.toList());

        return projectDtos;
    }

    // Autres méthodes métier pour Project

    public ProjectDto createProject(ProjectDto projectDto) {
        Project project = projectMapper.fromProjectDto(projectDto);
        if (project.getProjectID() != null) {
            throw new IllegalArgumentException("Cannot create a project with this id");
        }
        Project savedProject = projectRepository.save(project);
        return projectMapper.fromProject(savedProject);
    }

    public ProjectDto updateProject(ProjectDto projectDto) {
        /*Project oldProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        oldProject.setProjectName(projectDto.getProjectName());
        oldProject.setBudget(projectDto.getBudget());
        oldProject.setAmountPaid(projectDto.getAmountPaid());
        oldProject.setCreationDate(projectDto.getCreationDate());
        oldProject.setProjectType(projectDto.getProjectType());
        oldProject.setOwner(employeeRepository.findById(projectDto.getOwnerId()).get());
        oldProject.setDescription(projectDto.getDescription());
        oldProject.setProjectStatus(projectDto.getProjectStatus());
        oldProject.setPhases(loadPhases(projectDto.getProjectPhaseId()));
        oldProject.setEmployees(loadEmployees(projectDto.getEmployeesId()));
        oldProject.setExpenses(loadExpenses(projectDto.getExpensesId()));
        projectRepository.save(oldProject);*/

        Project project = projectMapper.fromProjectDto(projectDto);
        Project updatedProject = projectRepository.save(project);
        return projectMapper.fromProject(updatedProject);
    }

    private Set<ProjectPhase> loadPhases(Set<Long> phasesId) {
        return phasesId.stream()
                .map(projectPhaseRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    private Set<Employee> loadEmployees(Set<Long> employeesId) {
        return employeesId.stream()
                .map(employeeRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    private Set<Expense> loadExpenses(Set<Long> expensesId) {
        return expensesId.stream()
                .map(expenseRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    public void deleteProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        projectRepository.deleteById(projectId);
    }

    public ProjectDto getProjectById(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        return projectMapper.fromProject(project);
    }

    public Set<EmployeeDto> getEmployeesByProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project with ID " + projectId + " not found"));
        Set<Employee> employees = project.getEmployees();
        Set<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> employeeMapper.fromEmployee(employee))
                .collect(Collectors.toSet());
        return employeeDtos;
    }

    public List<ProjectDto> getProjectsByStatus(ProjectStatus status) {
        List<Project> projects = projectRepository.findByProjectStatus(status);
        List<ProjectDto> projectDtos = projects.stream()
                .map(project -> projectMapper.fromProject(project))
                .collect(Collectors.toList());
        return projectDtos;
    }

    public List<ProjectDto> getProjectsByType(String type) {
        List<Project> projects = projectRepository.findByProjectType(type);
        return projects.stream()
                .map(project -> projectMapper.fromProject(project))
                .collect(Collectors.toList());
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

    public List<ProjectDto> getCanceledProjects() {
        List<Project> allProjects = projectRepository.findAll();
        List<Project> canceledProjects = allProjects.stream()
                .filter(project -> project.getProjectStatus().equals(ProjectStatus.CANCELED))
                .collect(Collectors.toList());
        return canceledProjects.stream()
                .map(project -> projectMapper.fromProject(project))
                .collect(Collectors.toList());
    }

    public List<ProjectDto> getCompletedProjects() {
        List<Project> allProjects = projectRepository.findAll();
        List<Project> completedProjects = allProjects.stream()
                .filter(project -> project.getProjectStatus().equals(ProjectStatus.COMPLETED))
                .collect(Collectors.toList());
        return completedProjects.stream()
                .map(project -> projectMapper.fromProject(project))
                .collect(Collectors.toList());
    }


}
