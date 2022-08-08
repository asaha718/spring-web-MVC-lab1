package com.example.demo.dto;

import com.example.demo.model.Activity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CamperDTO {
    private int id;
    private String name;
    private int age;
    private List<Activity> activityList = new ArrayList<>();
}

