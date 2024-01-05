package com.example.GestionEntreprise.mappers;

import com.example.GestionEntreprise.dtos.DivisionDto;
import com.example.GestionEntreprise.dtos.EmployeeDto;
import com.example.GestionEntreprise.model.Division;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.service.DivisionService;
import com.example.GestionEntreprise.service.EmployeeService;
import com.example.GestionEntreprise.service.PayrollService;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {

    DivisionService divisionService;

    public Division mapToDivision(DivisionDto divisionDto){
        Division division = new Division();
        division.setDivisionName(divisionDto.getDivisionName());
        division.setHead(divisionDto.getHead());
        return division;
    }

    public DivisionDto mapToDivisionDto(Division division){
        DivisionDto divisionDto = new DivisionDto();
        divisionDto.setDivisionID(division.getDivisionID());
        divisionDto.setDivisionName(division.getDivisionName());
        divisionDto.setHead(division.getHead());

        return divisionDto;
    }
}
