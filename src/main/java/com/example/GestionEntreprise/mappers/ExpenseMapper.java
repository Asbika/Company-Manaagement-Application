package com.example.GestionEntreprise.mappers;

import com.example.GestionEntreprise.dtos.ExpenseDto;
import com.example.GestionEntreprise.model.Expense;
import com.example.GestionEntreprise.model.Project;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ExpenseMapper {

    public ExpenseDto fromExpense(Expense expense) {
        ExpenseDto expenseDto = new ExpenseDto();
        BeanUtils.copyProperties(expense, expenseDto);
        expenseDto.setExpenseID(expense.getExpenseID());
        expenseDto.setProjectId(expense.getProject().getProjectID());
        return expenseDto;
    }

    public Expense fromExpenseDto(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        BeanUtils.copyProperties(expenseDto, expense);
        expense.setExpenseID(expenseDto.getExpenseID());
        Project project = new Project();
        project.setProjectID(expenseDto.getProjectId());
        expense.setProject(project);
        return expense;
    }
}
