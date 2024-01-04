package com.example.GestionEntreprise.mappers;

import com.example.GestionEntreprise.dtos.ProjectDto;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.Expense;
import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.model.ProjectPhase;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProjectMapper {

    public ProjectDto fromProject(Project project) {
        ProjectDto projectDto = new ProjectDto();
        BeanUtils.copyProperties(project, projectDto);
        projectDto.setProjectID(project.getProjectID());

        if (project.getOwner() != null) {
            projectDto.setOwnerId(project.getOwner().getEmployeeID());
        }

        if(project.getPhases() != null) {
            projectDto.setProjectPhaseId(project.getPhases().stream()
                    .map(ProjectPhase::getPhaseID)
                    .collect(Collectors.toSet()));
        }

        if(project.getEmployees() != null) {
            projectDto.setEmployeesId(project.getEmployees().stream()
                    .map(Employee::getEmployeeID)
                    .collect(Collectors.toSet()));
        }

        if(project.getExpenses() != null) {
            projectDto.setExpensesId(project.getExpenses().stream()
                    .map(Expense::getExpenseID)
                    .collect(Collectors.toSet()));
        }
        return projectDto;
    }

    public Project fromProjectDto(ProjectDto projectDto) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDto, project);
        project.setProjectID(projectDto.getProjectID());

        if (projectDto.getOwnerId() != null) {
            Employee owner = new Employee();
            owner.setEmployeeID(projectDto.getOwnerId());
            project.setOwner(owner);
        }

        if(projectDto.getProjectPhaseId() != null) {
            project.setPhases(projectDto.getProjectPhaseId().stream()
                    .map(phaseId -> {
                        ProjectPhase phase = new ProjectPhase();
                        phase.setPhaseID(phaseId);
                        return phase;
                    })
                    .collect(Collectors.toSet()));
        }

        if(projectDto.getEmployeesId() != null) {
            project.setEmployees(projectDto.getEmployeesId().stream()
                    .map(employeeId -> {
                        Employee employee = new Employee();
                        employee.setEmployeeID(employeeId);
                        return employee;
                    })
                    .collect(Collectors.toSet()));
        }

        if(projectDto.getExpensesId() != null) {
            project.setExpenses(projectDto.getExpensesId().stream()
                    .map(expenseId -> {
                        Expense expense = new Expense();
                        expense.setExpenseID(expenseId);
                        return expense;
                    })
                    .collect(Collectors.toSet()));
        }

        return project;
    }
}
