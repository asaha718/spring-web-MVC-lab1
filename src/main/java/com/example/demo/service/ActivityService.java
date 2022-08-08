package com.example.demo.service;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CamperDTO;
import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    private ModelMapper mapper;

    public Activity createActivity(Activity activity){
        return activityRepository.save(activity);
    }

    public List<Activity> getActivities(){
        return activityRepository.findAll();
    }

    public ActivityDTO getActivity(int id){
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.map(activity, ActivityDTO.class);
    }
    public void deleteActivity(Integer id){
//        activityRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        activityRepository.deleteById(id);
    }
}
