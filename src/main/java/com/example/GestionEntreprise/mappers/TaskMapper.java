package com.example.GestionEntreprise.mappers;

import com.example.GestionEntreprise.dtos.TaskDto;
import com.example.GestionEntreprise.model.*;
import com.example.GestionEntreprise.service.EmployeeService;
import com.example.GestionEntreprise.service.ProjectPhaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TaskMapper {


    EmployeeService employeeService;
    ProjectPhaseService projectPhaseService;

    public Task mapToTask(TaskDto taskDto){
        Task task = new Task();
        BeanUtils.copyProperties(taskDto, task);
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
