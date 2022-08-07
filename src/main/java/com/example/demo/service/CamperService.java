package com.example.demo.service;

import com.example.demo.dto.CamperDTO;
import com.example.demo.model.Camper;
import com.example.demo.repository.CamperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CamperService {
    @Autowired
    CamperRepository camperRepository;
    @Autowired
    private ModelMapper mapper;

    public Camper createCamper(Camper camper){
        return camperRepository.save(camper);
    }

    public List<Camper> getCampers(){
        return camperRepository.findAll();
    }

    public CamperDTO getCamper(Integer id){
        Camper camper = camperRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.map(camper, CamperDTO.class);
    }
}
