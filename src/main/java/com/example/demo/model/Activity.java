package com.example.demo.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ACTIVITIES")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
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
    private List<SignUp> signUps = new ArrayList<>();

}
