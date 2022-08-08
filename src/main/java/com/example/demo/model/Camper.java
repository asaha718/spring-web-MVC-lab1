package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CAMPERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camper {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @NotBlank
    private String name;
    @Min(8)
    @Max(18)
    private int age;
    private LocalDate created_at;
    private LocalDate updated_at;

    @OneToMany
    private List<SignUp> signUps= new ArrayList<>();

}
