package com.example.GestionEntreprise.dtos;

import com.example.GestionEntreprise.model.Employee;
import com.example.GestionEntreprise.model.Payroll;
import com.example.GestionEntreprise.model.Task;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class DivisionDto {

    private Long divisionID;
    private String divisionName;
    private Employee head;

    public Long getDivisionID() {
        return divisionID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public Employee getHead() {
        return head;
    }

    public void setDivisionID(Long divisionID) {
        this.divisionID = divisionID;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public DivisionDto() {
    }

    @Override
    public String toString() {
        return "DivisionDto{" +
                "divisionID=" + divisionID +
                ", divisionName='" + divisionName + '\'' +
                ", head=" + head +
                '}';
    }
}

