package com.ashref.missionmanagement.Repository;

import com.ashref.missionmanagement.Models.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    List<Personnel> findByEducationListSchool(String schoolName);

}
