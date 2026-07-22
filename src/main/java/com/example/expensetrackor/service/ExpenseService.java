package com.example.expensetrackor.service;

import com.example.expensetrackor.dto.ExpenseRequestDto;
import com.example.expensetrackor.dto.ExpenseResponseDto;

import java.util.List;

public interface ExpenseService {
    ExpenseResponseDto createExpense(ExpenseRequestDto expenseRequestDto);

    List<ExpenseResponseDto> findAllExpenses(Long id);

    ExpenseResponseDto updateService(Long id,ExpenseRequestDto expenseRequestDto);

    void deleteById(Long id);

    void deleteByTitle(String title);

}
