package com.example.GestionEntreprise.mappers;

import com.example.GestionEntreprise.dtos.EmployeeProjectDto;
import com.example.GestionEntreprise.model.EmployeeProject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProjectMapper {

    public EmployeeProjectDto fromEmployeeProject(EmployeeProject employeeProject) {
        EmployeeProjectDto employeeProjectDto = new EmployeeProjectDto();
        BeanUtils.copyProperties(employeeProject, employeeProjectDto);
        employeeProjectDto.setEmployeeId(employeeProject.getEmployee().getEmployeeID());
        employeeProjectDto.setProjectId(employeeProject.getProject().getProjectID());
        return employeeProjectDto;
    }

    public EmployeeProject fromEmployeeProjectDto(EmployeeProjectDto employeeProjectDto) {
        EmployeeProject employeeProject = new EmployeeProject();
        BeanUtils.copyProperties(employeeProjectDto, employeeProject);
        return employeeProject;
    }
}
