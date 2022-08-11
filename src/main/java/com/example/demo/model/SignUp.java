package com.example.demo.model;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Table(name="SIGNUPS")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
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

