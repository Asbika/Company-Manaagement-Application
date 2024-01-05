package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.mappers.TaskMapper;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.ProjectPhase;
import com.example.GestionEntreprise.model.Task;
import com.example.GestionEntreprise.dtos.TaskDto;
import com.example.GestionEntreprise.repository.EmployeeRepository;
import com.example.GestionEntreprise.repository.ProjectPhaseRepository;
import com.example.GestionEntreprise.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectPhaseRepository projectPhaseRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository,
                       EmployeeRepository employeeRepository,
                       ProjectPhaseRepository projectPhaseRepository,
                       TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.projectPhaseRepository = projectPhaseRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskDto> findAll() {
        List<Task> listOfTasks = taskRepository.findAll();
        List<TaskDto> listeTaskDtos = new ArrayList<>();

        listOfTasks.forEach(task -> {
            listeTaskDtos.add(taskMapper.mapToTaskDto(task));
        });

        return listeTaskDtos;
    }

    public TaskDto findById(Long id) throws Exception {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task : " + id + "Not Found"));

        return taskMapper.mapToTaskDto(task);
    }

    public Task add(TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        return taskRepository.save(task);
    }

    public TaskDto updateTask(TaskDto taskDto, Long id) throws Exception {
        Task task = taskRepository.findById(id).orElseThrow(() -> new Exception("Task : " + id + "Not Found"));

        task.setStartDate(taskDto.getStartDate());
        task.setEndDate(taskDto.getEndDate());
        task.setDescription(taskDto.getDescription());

        Optional<Employee> employee = employeeRepository.findById(taskDto.getTaskID());
        employee.ifPresent(task::setResponsible);

        Optional<ProjectPhase> projectPhase = projectPhaseRepository.findById(taskDto.getProjectPhaseId());
        projectPhase.ifPresent(task::setProjectPhase);

        taskRepository.save(task);
        return taskMapper.mapToTaskDto(task);
    }

    public void delete(Long id) throws Exception {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task : " + id + "Not Found"));

        taskRepository.delete(task);
    }
}