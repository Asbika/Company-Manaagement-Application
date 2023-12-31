package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class EmployeeService {

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
    
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}

