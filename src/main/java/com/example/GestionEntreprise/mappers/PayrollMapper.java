package com.example.GestionEntreprise.mappers;

import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.Payroll;
import com.example.GestionEntreprise.model.PayrollDto;
import com.example.GestionEntreprise.service.EmployeeService;

public class PayrollMapper {


    EmployeeService employeeService;
    public Payroll mapToPayroll(PayrollDto payrollDto){
        Payroll payroll = new Payroll();
        payroll.setPayrollID(payroll.getPayrollID());
        payroll.setPayDate(payrollDto.getPayDate());
        payroll.setAmount(payrollDto.getAmount());
        Employee employee = employeeService.getdById(payrollDto.getEmployeeId());
        payroll.setEmployee(employee);
        return payroll;
    }

    public PayrollDto mapToPayrollDto(Payroll payroll){
        PayrollDto payrollDto = new PayrollDto();
        payrollDto.setAmount(payroll.getAmount());
        payrollDto.setPayDate(payroll.getPayDate());
        payrollDto.setPayrollID(payroll.getPayrollID());
        System.out.println(payroll.getEmployee().getEmployeeID());
        payrollDto.setEmployeeId(payroll.getEmployee().getEmployeeID());
        return payrollDto;
    }




}
