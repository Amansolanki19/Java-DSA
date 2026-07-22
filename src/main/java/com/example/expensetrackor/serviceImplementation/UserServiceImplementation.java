package com.example.expensetrackor.serviceImplementation;

import com.example.expensetrackor.dto.LoginRequestDto;
import com.example.expensetrackor.dto.LoginResponseDto;
import com.example.expensetrackor.dto.UserRequestDto;
import com.example.expensetrackor.dto.UserResponseDto;
import com.example.expensetrackor.model.Users;
import com.example.expensetrackor.repository.UserRepo;
import com.example.expensetrackor.service.EmailService;
import com.example.expensetrackor.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepo userRepo;
    private final EmailService emailService;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto findById(Long id) {

        Users user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    @Override
    public UserResponseDto createUser(UserRequestDto user) {

        Users users = Users.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .createdAt(LocalDateTime.now())
                .build();

        Users savedUser = userRepo.save(users);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );


    }



    @Override
    public List<UserResponseDto> findAll() {
        List<Users> users = userRepo.findAll();

        return users.stream()
                .map(user -> new UserResponseDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public String sendOtp(String email) {

        Users user = userRepo.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found.");
        }

        SecureRandom random = new SecureRandom();

        String otp = String.format("%06d", random.nextInt(1000000));

        user.setOtp(otp);

        user.setOtpExpiry(LocalDateTime.now().plusMinutes(5));

        userRepo.save(user);

        emailService.sendOtp(email, otp);

        return "OTP sent successfully.";
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Users users = userRepo.findByEmail(loginRequestDto.getEmail());

        if(users==null) throw new RuntimeException("User not found");

//        if(!passwordEncoder.matches(loginRequestDto.getPassword(),users.getPassword())){
//            throw new RuntimeException("Please Enter valid Password!!");
//        }

        if (!users.getPassword().equals(loginRequestDto.getPassword())) {
            throw new RuntimeException("Invalid Password.");
        }

        return LoginResponseDto.builder()
                .id(users.getId())
                .name(users.getName())
                .email(users.getEmail())
                .message("Login Successful")
                .build();

    }

    @Override
    public String verifyOtp(String email, String otp) {

        Users user = userRepo.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found.");
        }

        if (user.getOtp() == null) {
            throw new RuntimeException("Please generate OTP first.");
        }

        if (!user.getOtp().trim().equals(otp.trim())) {
            throw new RuntimeException("Invalid OTP.");
        }

        if (user.getOtpExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP has expired.");
        }

        return "OTP verified successfully.";
    }

    @Override
    public String resetPassword(String email, String newPassword) {

        System.out.println("Email: " + email);
        System.out.println("New Password: " + newPassword);

        Users user = userRepo.findByEmail(email);

        System.out.println("User Before: " + user);

        user.setPassword((newPassword));

        System.out.println("Encoded Password: " + user.getPassword());

        user.setOtp(null);
        user.setOtpExpiry(null);

        userRepo.save(user);

        return "Password changed successfully.";
    }


}