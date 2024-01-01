package com.example.GestionEntreprise.mappers;

import com.example.GestionEntreprise.model.*;
import com.example.GestionEntreprise.repository.EmployeeRepository;
import com.example.GestionEntreprise.service.EmployeeService;
import com.example.GestionEntreprise.service.ProjectPhaseService;

public class TaskMapper {


    EmployeeService employeeService;
    ProjectPhaseService projectPhaseService;

    public Task mapToTask(TaskDto taskDto){
        Task task = new Task();
        task.setTaskID(taskDto.getTaskID());
        task.setDescription(taskDto.getDescription());
        task.setResponsible(employeeService.getdById(taskDto.getResponsibleId()));
        task.setEndDate(taskDto.getEndDate());
        task.setStartDate(taskDto.getStartDate());
        task.setProjectPhase(projectPhaseService.findById(taskDto.getProjectPhaseId()));

        return task;
    }
    public TaskDto mapToTaskDto(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskID(task.getTaskID());
        taskDto.setDescription(task.getDescription());
        taskDto.setStartDate(task.getStartDate());
        taskDto.setEndDate(task.getEndDate());
        taskDto.setResponsibleId(task.getResponsible().getEmployeeID());
        taskDto.setProjectPhaseId(task.getProjectPhase().getPhaseID());

        return taskDto;
    }




}
