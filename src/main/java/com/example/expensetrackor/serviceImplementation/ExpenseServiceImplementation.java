package com.example.expensetrackor.serviceImplementation;

import com.example.expensetrackor.dto.ExpenseRequestDto;
import com.example.expensetrackor.dto.ExpenseResponseDto;
import com.example.expensetrackor.model.ExpenseData;
import com.example.expensetrackor.model.Users;
import com.example.expensetrackor.repository.ExpenseDataRepo;
import com.example.expensetrackor.repository.UserRepo;
import com.example.expensetrackor.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImplementation implements ExpenseService {

    private final UserRepo userRepo;
    private final ExpenseDataRepo expenseDataRepo;

    @Override
    public ExpenseResponseDto createExpense(ExpenseRequestDto request) {

        Users user = userRepo.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found with id : " + request.getUserId()));

        ExpenseData expense = ExpenseData.builder()
                .title(request.getTitle())
                .amount(request.getAmount())
                .description(request.getDescription())
                .category(request.getCategory())
                .status(request.getStatus())
                .user(user)
                .build();

        ExpenseData expenseData = expenseDataRepo.save(expense);

        return ExpenseResponseDto.builder()
                .id(expenseData.getId())
                .title(expenseData.getTitle())
                .amount(expenseData.getAmount())
                .description(expenseData.getDescription())
                .category(expenseData.getCategory())
                .status(expenseData.getStatus())
                .createdAt(expenseData.getCreatedAt())
                .updatedAt(expenseData.getUpdatedAt())
                .userId(user.getId())
                .userName(user.getName())
                .userEmail(user.getEmail())
                .build();

    }

    @Override
    public ExpenseResponseDto updateService(Long id, ExpenseRequestDto expenseRequestDto) {
        ExpenseData expenseData = expenseDataRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expenseData.setAmount(expenseRequestDto.getAmount());
        expenseData.setDescription(expenseRequestDto.getDescription());
        expenseData.setCategory(expenseRequestDto.getCategory());
        expenseData.setStatus(expenseRequestDto.getStatus());
        expenseData.setTitle(expenseRequestDto.getTitle());

        expenseData = expenseDataRepo.save(expenseData);

        return ExpenseResponseDto.builder()
                .id(expenseData.getId())
                .title(expenseData.getTitle())
                .amount(expenseData.getAmount())
                .description(expenseData.getDescription())
                .category(expenseData.getCategory())
                .status(expenseData.getStatus())
                .createdAt(expenseData.getCreatedAt())
                .updatedAt(expenseData.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteByTitle(String title) {
        if (!expenseDataRepo.existsByTitle(title)){
            throw new RuntimeException("Expense with title: "+title+" not found");
        }

        expenseDataRepo.deleteByTitle(title);
    }

    @Override
    public void deleteById(Long id) {

        if (!expenseDataRepo.existsById(id)) {
            throw new RuntimeException("Expense not found with id: " + id);
        }

        expenseDataRepo.deleteById(id);
    }

    @Override
    public List<ExpenseResponseDto> findAllExpenses(Long id) {

        Users user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        List<ExpenseData> expenses = expenseDataRepo.findByUserId(id);

        return expenses.stream()
                .map(expense -> ExpenseResponseDto.builder()
                        .id(expense.getId())
                        .title(expense.getTitle())
                        .amount(expense.getAmount())
                        .description(expense.getDescription())
                        .category(expense.getCategory())
                        .status(expense.getStatus())
                        .createdAt(expense.getCreatedAt())
                        .updatedAt(expense.getUpdatedAt())
                        .userId(user.getId())
                        .userName(user.getName())
                        .userEmail(user.getEmail())
                        .build())
                .collect(Collectors.toList());
    }
}