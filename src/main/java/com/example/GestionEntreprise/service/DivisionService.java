package com.example.GestionEntreprise.service;

import com.example.GestionEntreprise.dtos.DivisionDto;
import com.example.GestionEntreprise.dtos.TaskDto;
import com.example.GestionEntreprise.mappers.DivisionMapper;
import com.example.GestionEntreprise.mappers.TaskMapper;
import com.example.GestionEntreprise.model.Division;
import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.ProjectPhase;
import com.example.GestionEntreprise.model.Task;
import com.example.GestionEntreprise.repository.DivisionRepository;
import com.example.GestionEntreprise.repository.EmployeeRepository;
import com.example.GestionEntreprise.repository.ProjectPhaseRepository;
import com.example.GestionEntreprise.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DivisionService {


    private DivisionRepository divisionRepository;
    private final DivisionMapper divisionMapper;

    @Autowired
    public DivisionService(DivisionMapper divisionMapper,DivisionRepository divisionRepository) {
        this.divisionMapper = divisionMapper;
        this.divisionRepository = divisionRepository;
    }

    public List<DivisionDto> findAll() {

        List<Division> listOfDivisions = divisionRepository.findAll();
        List<DivisionDto> listOfDivisionDto = new ArrayList<>();

        listOfDivisions.forEach(division -> {
            listOfDivisionDto.add(divisionMapper.mapToDivisionDto(division));
        });

        return listOfDivisionDto;
    }

    public Division add(DivisionDto divisionDto) {
        Division division = divisionMapper.mapToDivision(divisionDto);

        return divisionRepository.save(division);
    }

    public void delete(Long id) throws Exception {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new Exception("Division : " + id + "Not Found"));

        divisionRepository.delete(division);
    }

    public DivisionDto updateDivision(DivisionDto divisionDto, Long id) throws Exception {
        Division division = divisionRepository.findById(id).orElseThrow(() -> new Exception("Division : " + id + "Not Found"));

        division.setDivisionName(divisionDto.getDivisionName());
        division.setHead(divisionDto.getHead());

        System.out.println(divisionRepository.save(division));

        return divisionMapper.mapToDivisionDto(division);
    }

}
