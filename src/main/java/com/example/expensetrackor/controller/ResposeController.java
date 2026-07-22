package com.example.expensetrackor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResposeController {
    @GetMapping("/")
    public ResponseEntity<String> response(){
        return ResponseEntity.ok("Successfully");
    }
}
