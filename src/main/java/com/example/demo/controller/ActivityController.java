package com.example.demo.controller;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<ActivityDTO> readActivities(){
        return activityService.getActivities();
    }
    @GetMapping("/{id}")
    public ActivityDTO readActivity(@PathVariable Integer id){
        return activityService.getActivity(id);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Integer id){
        activityService.deleteActivity(id);
    }

}
