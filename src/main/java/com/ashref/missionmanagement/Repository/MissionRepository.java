package com.ashref.missionmanagement.Repository;

import com.ashref.missionmanagement.Models.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    List<Mission> findByClientName(String clientName);
}
