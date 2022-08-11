package com.example.demo.service;

import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CampersDTO;
import com.example.demo.dto.CreateCamperDTO;
import com.example.demo.model.Camper;
import com.example.demo.repository.CamperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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

    @Autowired
    @Lazy
    private SignUpService signUpService;

    public CamperDTO createCamper(CreateCamperDTO createCamperDTO){
        Camper camper = mapper.map(createCamperDTO, Camper.class);

        return mapper.map(camperRepository.save(camper), CamperDTO.class);
    }

    public List<CampersDTO> getCampers(){
        return camperRepository.findAll().stream().map(camper -> mapper.map(camper, CampersDTO.class)).toList();
    }

    public CamperDTO getCamper(Integer id){
        CamperDTO camper = camperRepository.findById(id).map(camper1 -> mapper.map(camper1, CamperDTO.class)).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        camper.setActivityList(signUpService.getActivitiesByCamperId(id));
        return camper;
    }

    public Camper getCamperById(int id){ return  camperRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)); };
}
