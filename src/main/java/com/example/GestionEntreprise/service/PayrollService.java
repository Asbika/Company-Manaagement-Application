package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.model.Payroll;
import com.example.GestionEntreprise.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    public List<Payroll> findAll() {
        return payrollRepository.findAll();
    }

    // Autres méthodes métier pour Payroll
}
