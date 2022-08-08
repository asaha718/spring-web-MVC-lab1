package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ACTIVITIES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int difficulty;
    private LocalDate created_at;
    private LocalDate updated_at;
    @OneToMany(mappedBy = "activity")
    private List<SignUp> signup = new ArrayList<>();

}
