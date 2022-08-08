package com.example.demo.controller;

import com.example.demo.dto.CamperDTO;
import com.example.demo.model.Camper;
import com.example.demo.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {
    @Autowired
    private CamperService camperService;

    @PostMapping
    public Camper createCamper(@RequestBody Camper camper){
        return camperService.createCamper(camper);
    }

    @GetMapping
    public List<Camper> readCampers(){
        return camperService.getCampers();
    }

    @GetMapping("/{id}")
    public CamperDTO getCamper(@PathVariable Integer id){
        return camperService.getCamper(id);
    }
}
