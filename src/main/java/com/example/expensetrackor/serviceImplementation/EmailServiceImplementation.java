package com.example.expensetrackor.serviceImplementation;


import com.example.expensetrackor.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImplementation implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendOtp(String email, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Expense Tracker Password Reset OTP");

        message.setText(
                "Hello,\n\n"
                        + "Your OTP for password reset is : "
                        + otp
                        + "\n\nThis OTP is valid for 5 minutes."
                        + "\n\nThank You."
        );

        mailSender.send(message);
    }
}
