package com.ashref.missionmanagement.Services;


import com.ashref.missionmanagement.Models.Mission;
import com.ashref.missionmanagement.Models.Personnel;
import com.ashref.missionmanagement.Repository.MissionRepository;
import com.ashref.missionmanagement.Repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {

    @Autowired
    private final PersonnelRepository personnelRepository;
    @Autowired
    private final MissionRepository missionRepository;

    public MissionService(PersonnelRepository personnelRepository, MissionRepository missionRepository) {
        this.personnelRepository = personnelRepository;
        this.missionRepository = missionRepository;
    }


    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    public Mission getMissionById(Long id) {
        return missionRepository.findById(id).orElse(null);
    }

    public List<Personnel> getMissionPersonnel(Long id) {
        return missionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mission not found with id: " + id)).getPersonnelList();
    }

    public void addMission(Mission mission) {
        missionRepository.save(mission);
    }

    public boolean updateMission(long id, Mission mission) {
        Mission updatedMission = missionRepository.findById(id).orElse(null);
        if (updatedMission != null) {
            updatedMission.setName(mission.getName());
            updatedMission.setDescription(mission.getDescription());
            updatedMission.setLocation(mission.getLocation());
            updatedMission.setStartDate(mission.getStartDate());
            updatedMission.setEndDate(mission.getEndDate());
            missionRepository.save(updatedMission);
            return true;
        }
        return false;
    }

    public boolean deleteMission(long id) {
        return missionRepository.findById(id).map(mission -> {
            missionRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    public Mission addPersonnelToMission(Long missionId, Long personnelId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("Mission not found with id: " + missionId));

        Personnel personnel = personnelRepository.findById(personnelId)
                .orElseThrow(() -> new RuntimeException("Personnel not found with id: " + personnelId));

        mission.getPersonnelList().add(personnel);
        return missionRepository.save(mission);
    }

    public boolean removePersonnelFromMission(Long missionId, Long personnelId) {
        Optional<Mission> optionalMission = missionRepository.findById(missionId);
        Optional<Personnel> optionalPersonnel = personnelRepository.findById(personnelId);

        if (optionalMission.isPresent() && optionalPersonnel.isPresent()) {
            Mission mission = optionalMission.get();
            Personnel personnel = optionalPersonnel.get();
            mission.getPersonnelList().remove(personnel);
            missionRepository.save(mission);

            return true;
        }
        return false;
    }
}
