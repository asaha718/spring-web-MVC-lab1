package com.example.demo.service;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CreateSignUpDTO;
import com.example.demo.model.SignUp;
import com.example.demo.repository.SignUpRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpService {
    @Autowired
    private SignUpRepository signUpRepository;

    @Autowired
    private CamperService camperService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ModelMapper mapper;

    public ActivityDTO createSignUp(CreateSignUpDTO createSignUpDTO){
        SignUp signUp = new SignUp();
        signUp.setTime(createSignUpDTO.getTime());
        signUp.setCamper(camperService.getCamperById(createSignUpDTO.getCamperId()));
        signUp.setActivity(activityService.getActivityById(createSignUpDTO.getActivityId()));
        signUp = signUpRepository.save(signUp);
        return mapper.map(signUp.getActivity(), ActivityDTO.class);
    }

    public List<ActivityDTO> getActivitiesByCamperId(int camperId){
        List<SignUp> signUpsForCampers = signUpRepository.findAllByCamperId(camperId);
        return signUpsForCampers.stream()
                .map(signUp -> signUp.getActivity())
                .map(activity -> mapper.map(activity, ActivityDTO.class))
                .toList();
    }
}
