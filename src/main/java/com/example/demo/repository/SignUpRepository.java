package com.example.demo.repository;

import com.example.demo.model.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SignUpRepository extends JpaRepository<SignUp, Integer> {
    List<SignUp> findAllByCamperId(int camperId);
}
