package com.ashref.missionmanagement.Models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Transactional
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String location;

    @Column
    private String clientName;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_mission_personnel", referencedColumnName = "mission_id")
    private List<Personnel> personnelList = new ArrayList<>();

}