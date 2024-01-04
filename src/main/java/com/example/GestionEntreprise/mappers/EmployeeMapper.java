package com.example.GestionEntreprise.mappers;

import com.example.GestionEntreprise.dtos.EmployeeDto;
import com.example.GestionEntreprise.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public EmployeeDto fromEmployee(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }

    public Employee fromEmployeeDto(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }
}
