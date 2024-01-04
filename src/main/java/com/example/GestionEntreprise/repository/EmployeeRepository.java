package com.example.GestionEntreprise.repository;

import com.example.GestionEntreprise.model.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

    @Query("SELECT e FROM Employee e WHERE e.employeeID NOT IN (SELECT ep.employee.employeeID FROM EmployeeProject ep )")
    List<Employee> findAvailableEmployeesForProject();
}
