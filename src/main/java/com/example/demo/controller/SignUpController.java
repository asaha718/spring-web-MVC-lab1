package com.example.demo.controller;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CreateSignUpDTO;
import com.example.demo.model.SignUp;
import com.example.demo.service.ActivityService;
import com.example.demo.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/signups")
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ActivityDTO createSignUp(@Valid @RequestBody CreateSignUpDTO createSignUpDTO){
        return signUpService.createSignUp(createSignUpDTO);
    }
}
