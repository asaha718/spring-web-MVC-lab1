package com.example.demo.controller;

import com.example.demo.dto.ActivityDTO;
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
    @GetMapping("/{id}")
    public ActivityDTO readActivity(Integer id){
        return activityService.getActivity(id);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(Integer id){
        activityService.deleteActivity(id);
    }

}
