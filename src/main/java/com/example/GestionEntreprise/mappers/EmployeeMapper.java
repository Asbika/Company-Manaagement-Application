package com.example.GestionEntreprise.mappers;

import com.example.GestionEntreprise.dtos.EmployeeDto;
import com.example.GestionEntreprise.dtos.PayrollDto;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.Payroll;
import com.example.GestionEntreprise.service.EmployeeService;
import com.example.GestionEntreprise.service.PayrollService;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    EmployeeService employeeService;

    PayrollService payrollService;
    public Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setSalary(employeeDto.getSalary());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setEmployeeID(employeeDto.getEmployeeID());
        employee.setPayrolls(employeeDto.getPayrolls());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setContractType(employeeDto.getContractType());
        employee.setTasks(employeeDto.getTasks());
        return employee;
    }

    public EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeID(employee.getEmployeeID());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setContractType(employee.getContractType());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setHireDate(employee.getHireDate());
        employeeDto.setContractType(employee.getContractType());
        return employeeDto;
    }
}
