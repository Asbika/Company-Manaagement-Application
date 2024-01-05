package com.example.GestionEntreprise.controller;

import com.example.GestionEntreprise.dtos.EmployeeDto;
import com.example.GestionEntreprise.dtos.DivisionDto;
import com.example.GestionEntreprise.dtos.TaskDto;
import com.example.GestionEntreprise.mappers.DivisionMapper;
import com.example.GestionEntreprise.mappers.EmployeeMapper;
import com.example.GestionEntreprise.model.Division;
import com.example.GestionEntreprise.service.DivisionService;
import com.example.GestionEntreprise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/divisions")
public class DivisionController {

    private DivisionService divisionService;
    private DivisionMapper divisionMapper;
    @Autowired
    public DivisionController(DivisionMapper divisionMapper,
                              DivisionService divisionService) {
        this.divisionMapper = divisionMapper;
        this.divisionService = divisionService;
    }
    @GetMapping
    public List<DivisionDto> getAllDivisions() {
        return divisionService.findAll();
    }
    @PostMapping
    public ResponseEntity<DivisionDto> addEmployee(@RequestBody DivisionDto divisionDto){

        Division division = divisionService.add(divisionDto);
        DivisionDto divisionDto1 = divisionMapper.mapToDivisionDto(division);

        return new ResponseEntity<>(divisionDto1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) throws Exception {
        divisionService.delete(id);
        return new ResponseEntity<>("Division deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DivisionDto> updtae(@PathVariable Long id, @RequestBody DivisionDto divisionDto) throws Exception {
        DivisionDto st = divisionService.updateDivision(divisionDto,id);
        return new ResponseEntity<>(st, HttpStatus.OK);
    }
}
