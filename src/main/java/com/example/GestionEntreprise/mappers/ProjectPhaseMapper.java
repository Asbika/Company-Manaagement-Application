package com.example.GestionEntreprise.mappers;

import com.example.GestionEntreprise.dtos.ProjectPhaseDto;
import com.example.GestionEntreprise.model.ProjectPhase;
import com.example.GestionEntreprise.model.Task;
import com.example.GestionEntreprise.repository.ProjectRepository;
import com.example.GestionEntreprise.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectPhaseMapper {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectPhaseDto fromProjectPhase(ProjectPhase projectPhase) {
        ProjectPhaseDto projectPhaseDto = new ProjectPhaseDto();
        BeanUtils.copyProperties(projectPhase, projectPhaseDto);
        projectPhaseDto.setPhaseID(projectPhase.getPhaseID());
        projectPhaseDto.setProjectId(projectPhase.getProject().getProjectID());
        projectPhaseDto.setTasksId(projectPhase.getTasks().stream()
                .map(Task::getTaskID)
                .collect(Collectors.toSet()));
        return projectPhaseDto;
    }

    public ProjectPhase fromProjectPhaseDto(ProjectPhaseDto projectPhaseDto) {
        ProjectPhase projectPhase = new ProjectPhase();
        BeanUtils.copyProperties(projectPhaseDto, projectPhase);
        projectPhase.setPhaseID(projectPhaseDto.getPhaseID());
        projectPhase.setProject(projectRepository.findById(projectPhaseDto.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("Project not found")));
        if (projectPhaseDto.getTasksId() != null && !projectPhaseDto.getTasksId().isEmpty()) {
            Set<Task> tasks = new HashSet<>();
            for (Long taskId : projectPhaseDto.getTasksId()) {
                Task task = taskRepository.findById(taskId)
                        .orElseThrow(() -> new IllegalArgumentException("Task not found"));
                tasks.add(task);
            }
            projectPhase.setTasks(tasks);
        }
        return projectPhase;
    }
}
