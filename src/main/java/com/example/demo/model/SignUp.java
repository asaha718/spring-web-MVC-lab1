package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Table(name="SIGNUPS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUp {
    @Id
    @GeneratedValue
    private int id;
    @Min(0)
    @Max(23)
    private int time;
    private LocalDate created_at;
    private LocalDate updated_at;

    @ManyToOne
    private Camper camper;
    @ManyToOne
    private Activity activity;


}

