package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.dtos.PayrollDto;
import com.example.GestionEntreprise.dtos.TaskDto;
import com.example.GestionEntreprise.mappers.PayrollMapper;
import com.example.GestionEntreprise.mappers.TaskMapper;
import com.example.GestionEntreprise.model.Payroll;
import com.example.GestionEntreprise.model.Task;
import com.example.GestionEntreprise.repository.EmployeeRepository;
import com.example.GestionEntreprise.repository.ProjectPhaseRepository;
import com.example.GestionEntreprise.repository.TaskRepository;
import com.example.GestionEntreprise.service.TaskService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private TaskService taskService;
    private final TaskMapper taskMapper;
    @Autowired
    public TaskController(TaskService taskService,
                       TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.findAll();
    }
    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) throws Exception {
        return taskService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updtae(@PathVariable Long id, @RequestBody TaskDto taskDto) throws Exception {
        taskService.updateTask(taskDto,id);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto){

        TaskDto taskDto1 = taskMapper.mapToTaskDto(taskService.add(taskDto));
        return new ResponseEntity<>(taskDto1,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) throws Exception {
        taskService.delete(id);
        return new ResponseEntity<>("Task deleted successfully",HttpStatus.OK);
    }
}
