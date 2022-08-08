package com.example.demo.controller;

import com.example.demo.model.Activity;
import com.example.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> readActivities(){
        return activityService.getActivities();
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(int id){
        activityService.deleteActivity(id);
    }

}
