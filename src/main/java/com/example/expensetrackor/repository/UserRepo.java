package com.example.expensetrackor.repository;

import com.example.expensetrackor.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

        List<Users> findAll();

        Users findByEmail(String email);


}