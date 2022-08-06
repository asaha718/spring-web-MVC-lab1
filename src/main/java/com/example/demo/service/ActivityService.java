package com.example.demo.service;

import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    public Activity createActivity(Activity activity){
        return activityRepository.save(activity);
    }

    public List<Activity> getActivities(){
        return activityRepository.findAll();
    }

    public void deleteActivity(Integer id){
        activityRepository.deleteById(id);
    }
}
