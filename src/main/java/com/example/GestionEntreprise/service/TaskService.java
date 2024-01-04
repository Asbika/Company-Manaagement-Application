package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.mappers.TaskMapper;
import com.example.GestionEntreprise.model.Task;
import com.example.GestionEntreprise.dtos.TaskDto;
import com.example.GestionEntreprise.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public TaskDto findById(Long id){
        TaskMapper map = new TaskMapper();

        return map.mapToTaskDto(taskRepository.findById(id).get());
    }

    public void updateTasks(Set<Task> tasks) {
        for (Task task : tasks) {
            if (taskRepository.existsById(task.getTaskID())) {
                taskRepository.save(task);
            } else {
                throw new IllegalArgumentException("Task not found");
            }
        }
    }

}
