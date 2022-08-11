package com.example.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CamperDTO {
    private int id;
    private String name;
    private int age;
    private List<ActivityDTO> activityList = new ArrayList<>();
}

