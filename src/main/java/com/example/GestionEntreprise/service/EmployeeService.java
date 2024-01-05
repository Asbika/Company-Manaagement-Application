package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.dtos.EmployeeDto;
import com.example.GestionEntreprise.dtos.TaskDto;
import com.example.GestionEntreprise.mappers.EmployeeMapper;
import com.example.GestionEntreprise.mappers.TaskMapper;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.ProjectPhase;
import com.example.GestionEntreprise.model.Task;
import com.example.GestionEntreprise.repository.EmployeeRepository;

import com.example.GestionEntreprise.repository.ProjectPhaseRepository;
import com.example.GestionEntreprise.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;

    }
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findEmployeesByName(String name) {
        return employeeRepository.findByFirstNameContainingOrLastNameContaining(name, name);
    }


    public BigDecimal calculateAnnualSalary(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));
        return employee.getSalary().multiply(new BigDecimal("12")); // Supposant que le salaire est mensuel
    }
    
    public List<EmployeeDto> findAll() {

        List<EmployeeDto> employeeDtos = new ArrayList<>();
        employeeRepository.findAll().stream().forEach(employee -> {
            employeeDtos.add(employeeMapper.mapToEmployeeDto(employee));
        });
        return employeeDtos;
    }

    public Employee getdById(Long id){
        return employeeRepository.findById(id).get();
    }

    public EmployeeDto add(EmployeeDto employeeDto){
    Employee empl = employeeRepository.save(employeeMapper.mapToEmployee(employeeDto));

    return employeeMapper.mapToEmployeeDto(empl);
    }

    public void delete(Long id) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee : " + id + "Not Found"));

        employeeRepository.delete(employee);
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id) throws Exception {
        Employee employee = employeeRepository.findById(id)
                        .orElseThrow(() -> new Exception("Employee : " + id + "Not Found"));

        employee.setEmail(employeeDto.getEmail());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setTasks(employeeDto.getTasks());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setPayrolls(employeeDto.getPayrolls());
        employee.setSalary(employeeDto.getSalary());

        return employeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }
}

