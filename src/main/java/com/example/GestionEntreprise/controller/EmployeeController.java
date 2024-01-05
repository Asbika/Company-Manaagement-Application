package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.dtos.EmployeeDto;
import com.example.GestionEntreprise.dtos.TaskDto;
import com.example.GestionEntreprise.mappers.EmployeeMapper;
import com.example.GestionEntreprise.mappers.TaskMapper;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.service.EmployeeService;
import com.example.GestionEntreprise.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeController(EmployeeService employeeService,
                          EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }
    @GetMapping("/allEmployees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.findAll();
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){

        EmployeeDto emplDTO = employeeService.add(employeeDto);
        return new ResponseEntity<>(emplDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable Long id) throws Exception {

        employeeService.delete(id);
        return new ResponseEntity<>("Employee deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updtae(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) throws Exception {
        EmployeeDto employeeDto1 = employeeService.updateEmployee(employeeDto,id);
        return new ResponseEntity<>(employeeDto1, HttpStatus.OK);
    }
}
