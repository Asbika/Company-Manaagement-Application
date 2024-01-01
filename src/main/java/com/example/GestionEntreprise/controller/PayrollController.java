package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.mappers.PayrollMapper;
import com.example.GestionEntreprise.model.Payroll;
import com.example.GestionEntreprise.model.PayrollDto;
import com.example.GestionEntreprise.service.EmployeeService;
import com.example.GestionEntreprise.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/payrolls")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @Autowired
    private EmployeeService employeeService;
    //Get All Payrolls
    @GetMapping
    public List<PayrollDto> getAllPayrolls() {
        List<PayrollDto> list = new ArrayList<>();
        PayrollMapper map = new PayrollMapper();
        payrollService.findAll().stream().forEach(payroll -> {
            list.add(map.mapToPayrollDto(payroll));
        });
        return list;
    }

    //Add Payroll
    @PostMapping
    public ResponseEntity<PayrollDto> addPayroll(@RequestBody PayrollDto payrollDto){
        Payroll pay = new Payroll();
        pay.setEmployee(employeeService.getdById(payrollDto.getEmployeeId()));
        pay.setPayDate(payrollDto.getPayDate());
        pay.setAmount(payrollDto.getAmount());
        Payroll p=payrollService.add(pay);
        PayrollMapper map = new PayrollMapper();
        return new ResponseEntity<>(map.mapToPayrollDto(p),HttpStatus.CREATED);
    }

    //Get Payroll By Id
    @GetMapping("/{id}")
    public ResponseEntity<PayrollDto> getPayrollById(@PathVariable Long id) {

        PayrollDto payroll = payrollService.findById(id);
        return new ResponseEntity<>(payroll,HttpStatus.OK);
    }

    //Delete Payroll By Id
     @DeleteMapping("/{id}")
     public ResponseEntity<String> deletePayroll(@PathVariable Long id){
         payrollService.delete(id);
         return new ResponseEntity<>("Payroll deleted successfully",HttpStatus.OK);
     }

     //Update Payroll
    @PutMapping("/{id}")
     public ResponseEntity<PayrollDto> updatePayroll(@PathVariable Long id,@RequestBody PayrollDto payrollDto){
        PayrollDto payroll1 = payrollService.update(payrollDto,id);
        return new ResponseEntity<>(payroll1,HttpStatus.OK);
     }
}
