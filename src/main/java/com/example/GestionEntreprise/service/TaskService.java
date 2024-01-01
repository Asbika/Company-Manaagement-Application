package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.mappers.PayrollMapper;
import com.example.GestionEntreprise.mappers.TaskMapper;
import com.example.GestionEntreprise.model.PayrollDto;
import com.example.GestionEntreprise.model.Task;
import com.example.GestionEntreprise.model.TaskDto;
import com.example.GestionEntreprise.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public TaskDto findById(Long id){
        TaskMapper map = new TaskMapper();

        return map.mapToTaskDto(taskRepository.findById(id).get());
    }

}
