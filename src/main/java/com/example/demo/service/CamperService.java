package com.example.demo.service;

import com.example.demo.model.Camper;
import com.example.demo.repository.CamperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamperService {
    @Autowired
    CamperRepository camperRepository;

    public Camper createCamper(Camper camper){
        return camperRepository.save(camper);
    }

    public List<Camper> getCampers(){
        return camperRepository.findAll();
    }

    public Camper getCamper(Integer id){
        return camperRepository.findById(id).get();
    }
}
