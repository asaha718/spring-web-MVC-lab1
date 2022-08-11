package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CreateSignUpDTO {
    @Min(0)
    @Max(23)
    private int time;
    private int camperId;
    private int activityId; 
}
