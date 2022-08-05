package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ACTIVITIES")
public class Activity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int difficulty;
    private LocalDate created_at;
    private LocalDate updated_at;
    @OneToMany
    private List<Camper> camperList= new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public List<Camper> getCamperList() {
        return camperList;
    }

    public void setCamperList(List<Camper> camperList) {
        this.camperList = camperList;
    }
}
