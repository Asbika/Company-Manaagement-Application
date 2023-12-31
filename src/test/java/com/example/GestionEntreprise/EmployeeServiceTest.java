package com.example.GestionEntreprise;

import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.repository.EmployeeRepository;
import com.example.GestionEntreprise.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindEmployeesByName() {
        Employee emp1 = new Employee(); // Settez les propriétés nécessaires
        Employee emp2 = new Employee(); // Settez les propriétés nécessaires

        when(employeeRepository.findByFirstNameContainingOrLastNameContaining("John", "John"))
            .thenReturn(Arrays.asList(emp1, emp2));

        List<Employee> foundEmployees = employeeService.findEmployeesByName("John");

        assertEquals(2, foundEmployees.size());
        verify(employeeRepository, times(1)).findByFirstNameContainingOrLastNameContaining("John", "John");
    }
}
