package com.example.demo.service;

import com.example.demo.model.SignUp;
import com.example.demo.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    @Autowired
    SignUpRepository signUpRepository;

    public SignUp createSignUp(SignUp signUp){
        return signUpRepository.save(signUp);
    }

}
