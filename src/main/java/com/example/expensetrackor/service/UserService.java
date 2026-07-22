package com.example.expensetrackor.service;

import com.example.expensetrackor.dto.LoginRequestDto;
import com.example.expensetrackor.dto.LoginResponseDto;
import com.example.expensetrackor.dto.UserRequestDto;
import com.example.expensetrackor.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto user);

    UserResponseDto findById(Long id);

    List<UserResponseDto> findAll();


    String sendOtp(String email);

    String verifyOtp(String email, String otp);

    String resetPassword(String email, String newPassword);

    LoginResponseDto login(LoginRequestDto loginRequestDto);
}