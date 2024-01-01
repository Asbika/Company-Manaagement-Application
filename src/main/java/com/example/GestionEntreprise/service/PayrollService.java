package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.mappers.PayrollMapper;
import com.example.GestionEntreprise.model.Payroll;
import com.example.GestionEntreprise.model.PayrollDto;
import com.example.GestionEntreprise.repository.EmployeeRepository;
import com.example.GestionEntreprise.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Payroll> findAll() {
        return payrollRepository.findAll();
    }

    public PayrollDto findById(Long id){
        PayrollMapper map = new PayrollMapper();

        return map.mapToPayrollDto(payrollRepository.findById(id).get());
    }

    public Payroll add(Payroll payroll){
        return payrollRepository.save(payroll);
    }

    public PayrollDto update(PayrollDto payrollDto, Long id){
        Payroll payroll = payrollRepository.findById(id).get();
        PayrollMapper map = new PayrollMapper();
        if(payroll !=null){
            payroll.setAmount(payrollDto.getAmount());
            payroll.setPayDate(payrollDto.getPayDate());
            payroll.setEmployee(employeeRepository.findById(payrollDto.getEmployeeId()).get());
           return map.mapToPayrollDto(payrollRepository.save(payroll));
        }else{
            return null;
        }
    }

    public void delete(Long id){
        Optional<Payroll> payroll = payrollRepository.findById(id);
        if(payroll.isPresent()){
            payrollRepository.delete(payroll.get());
        }
    }
}
