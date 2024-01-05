package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.dtos.ProjectPhaseDto;
import com.example.GestionEntreprise.dtos.TaskDto;
import com.example.GestionEntreprise.mappers.ProjectPhaseMapper;
import com.example.GestionEntreprise.mappers.TaskMapper;
import com.example.GestionEntreprise.model.Project;
import com.example.GestionEntreprise.model.ProjectPhase;
import com.example.GestionEntreprise.model.Task;
import com.example.GestionEntreprise.repository.ProjectPhaseRepository;
import com.example.GestionEntreprise.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectPhaseService {

    @Autowired
    private ProjectPhaseRepository projectPhaseRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectPhaseMapper projectPhaseMapper;

    private TaskMapper taskMapper;
    private TaskService taskService;

    @Autowired
    public void setTaskMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Autowired
    public ProjectPhaseService(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<ProjectPhaseDto> getAllProjectPhases() {
        List<ProjectPhase> projectPhases = projectPhaseRepository.findAll();
        List<ProjectPhaseDto> projectPhaseDtos = projectPhases.stream()
                .map(projectPhase -> projectPhaseMapper.fromProjectPhase(projectPhase))
                .collect(Collectors.toList());
        return projectPhaseDtos;
    }

    public ProjectPhaseDto getProjectPhaseById(Long id){
        ProjectPhase projectPhase = projectPhaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project phase not found for this id"));
        return projectPhaseMapper.fromProjectPhase(projectPhase);
    }

    // Autres méthodes métier pour ProjectPhase

    public ProjectPhaseDto createProjectPhase(ProjectPhaseDto projectPhaseDto) {
        ProjectPhase projectPhase = projectPhaseMapper.fromProjectPhaseDto(projectPhaseDto);
        if (projectPhase.getPhaseID() != null) {
            throw new IllegalArgumentException("Cannot create a phase for this id");
        }
        ProjectPhase savedProjectPhase = projectPhaseRepository.save(projectPhase);
        return projectPhaseMapper.fromProjectPhase(savedProjectPhase);
    }

    public ProjectPhaseDto updateProjectPhase(ProjectPhaseDto projectPhaseDto) {
        if (projectPhaseDto.getPhaseID() == null) {
            throw new IllegalArgumentException("Project Phase ID cannot be null");
        }

        ProjectPhase oldProjectPhase = projectPhaseRepository.findById(projectPhaseDto.getPhaseID())
                .orElseThrow(() -> new IllegalArgumentException("Project Phase not found"));
        oldProjectPhase.setDescription(projectPhaseDto.getDescription());
        oldProjectPhase.setStartDate(projectPhaseDto.getStartDate());
        oldProjectPhase.setEndDate(projectPhaseDto.getEndDate());

        if (projectPhaseDto.getProjectId() == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }

        oldProjectPhase.setProject(projectRepository.findById(projectPhaseDto.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("Project not found")));

        ProjectPhase updatedProjectPhase = projectPhaseRepository.save(oldProjectPhase);
        return projectPhaseMapper.fromProjectPhase(updatedProjectPhase);
    }

    public void deleteProjectPhase(Long id) {
        ProjectPhase projectPhase = projectPhaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProjectPhase not found"));
        projectPhaseRepository.deleteById(id);
    }

    public List<ProjectPhaseDto> getPhasesByProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        List<ProjectPhase> projectPhases = projectPhaseRepository.findProjectPhaseByProject(project);
        return projectPhases.stream()
                .map(projectPhase -> projectPhaseMapper.fromProjectPhase(projectPhase))
                .collect(Collectors.toList());
    }

    /*public void addTasksToPhase(Long phaseId, Long projectId, List<TaskDto> taskDtos) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        ProjectPhase projectPhase = projectPhaseRepository.findById(phaseId)
                .orElseThrow(() -> new IllegalArgumentException("Phase not found"));
        for (TaskDto taskDto : taskDtos) {
            Task task =
        }

    }*/

    public int calculatePhaseDuration(Long phaseId) {
        ProjectPhase projectPhase = projectPhaseRepository.findById(phaseId)
                .orElseThrow(() -> new IllegalArgumentException("Project Phase not found"));

        if (projectPhase.getStartDate() != null && projectPhase.getEndDate() != null) {
            Duration duration = Duration.between(projectPhase.getStartDate().atStartOfDay(), projectPhase.getEndDate().atStartOfDay());
            return (int) duration.toDays();
        } else {
            throw new IllegalArgumentException("Start date or end date is missing for the phase");
        }
    }

    public ProjectPhaseDto updateTasksInPhase(Long phaseId, Set<TaskDto> taskDtos) {
        ProjectPhase projectPhase = projectPhaseRepository.findById(phaseId)
                .orElseThrow(() -> new IllegalArgumentException("Project Phase not found"));
        Set<Task> updatesTasks = taskDtos.stream()
                .map(taskDto -> taskMapper.mapToTask(taskDto))
                .collect(Collectors.toSet());
        updatesTasks.forEach(task -> task.setProjectPhase(projectPhase));
        taskService.updateTasks(updatesTasks);
        projectPhase.setTasks(updatesTasks);
        projectPhaseRepository.save(projectPhase);
        return projectPhaseMapper.fromProjectPhase(projectPhase);
    }

    public void deleteTasksInPhase(Long phaseId, Set<Long> tasksId) {
        ProjectPhase projectPhase = projectPhaseRepository.findById(phaseId)
                .orElseThrow(() -> new IllegalArgumentException("Project Phase not found"));
        Set<Task> tasksToDelete = projectPhase.getTasks().stream()
                .filter(task -> tasksId.contains(task.getTaskID()))
                .collect(Collectors.toSet());
        projectPhase.getTasks().removeAll(tasksToDelete);
        projectPhaseRepository.save(projectPhase);
    }
}
