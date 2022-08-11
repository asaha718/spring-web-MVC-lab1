package com.example.demo.controller;

import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CampersDTO;
import com.example.demo.dto.CreateCamperDTO;
import com.example.demo.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {
    @Autowired
    private CamperService camperService;

    @PostMapping
    public CamperDTO createCamper(@Valid @RequestBody CreateCamperDTO createCamperDTO){
        return camperService.createCamper(createCamperDTO);
    }

    @GetMapping
    public List<CampersDTO> readCampers(){
        return camperService.getCampers();
    }

    @GetMapping("/{id}")
    public CamperDTO getCamper(@PathVariable Integer id){
        return camperService.getCamper(id);
    }
}
