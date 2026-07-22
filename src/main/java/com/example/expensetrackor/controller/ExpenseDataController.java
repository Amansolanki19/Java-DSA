package com.example.expensetrackor.controller;

import com.example.expensetrackor.dto.ExpenseRequestDto;
import com.example.expensetrackor.dto.ExpenseResponseDto;
import com.example.expensetrackor.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expenseData")
public class ExpenseDataController {

    private final ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity<ExpenseResponseDto> createExpense(
            @Valid @RequestBody ExpenseRequestDto expenseRequestDto) {

        return ResponseEntity.ok(expenseService.createExpense(expenseRequestDto));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseResponseDto> updateExpense(@PathVariable Long id,
                                                            @Valid @RequestBody ExpenseRequestDto expenseRequestDto){
        ExpenseResponseDto expenseResponse = expenseService.updateService(id,expenseRequestDto);

        return ResponseEntity.ok(expenseResponse);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable Long id){
        expenseService.deleteById(id);
        return ResponseEntity.ok("Expense deleted Successfully");
    }

    @DeleteMapping("/title/{title}")
    public ResponseEntity<String> deleteExpenseByTitle(@PathVariable String title){
        expenseService.deleteByTitle(title);
        return ResponseEntity.ok("Expense deleted Successfully");
    }



    @GetMapping("/getAll/{userId}")
    public List<ExpenseResponseDto> findAllExpenses(@PathVariable Long userId){
        return expenseService.findAllExpenses(userId);
    }
}