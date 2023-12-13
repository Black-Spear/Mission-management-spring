package com.ashref.missionmanagement.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Long id;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    private String school;

    @Column
    private LocalDate graduationDate;

}
