package com.ashref.missionmanagement.Models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Transactional
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personnel_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String contactInformation;

    @Column(nullable = false)
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_personnel_education", referencedColumnName = "personnel_id")
    private List<Education> educationList = new ArrayList<>();


}
