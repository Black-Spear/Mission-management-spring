package com.ashref.missionmanagement.Controllers;

import com.ashref.missionmanagement.Models.Mission;
import com.ashref.missionmanagement.Models.Personnel;
import com.ashref.missionmanagement.Services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @GetMapping
    public ResponseEntity<List<Mission>> getAllMissions() {
        List<Mission> missions = missionService.getAllMissions();
        return new ResponseEntity<>(missions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mission> getMissionById(@PathVariable Long id) {
        Mission mission = missionService.getMissionById(id);
        return mission != null ? new ResponseEntity<>(mission, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/personnel")
    public ResponseEntity<List<Personnel>> getMissionPersonnel(@PathVariable Long id) {
        List<Personnel> personnelList = missionService.getMissionPersonnel(id);
        return new ResponseEntity<>(personnelList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addMission(@RequestBody Mission mission) {
        missionService.addMission(mission);
        return new ResponseEntity<>("Mission saved successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMission(@PathVariable Long id, @RequestBody Mission mission) {
        boolean updated = missionService.updateMission(id, mission);
        return updated ? new ResponseEntity<>("Mission updated successfully.", HttpStatus.OK) : new ResponseEntity<>("Mission not found.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMission(@PathVariable Long id) {
        boolean deleted = missionService.deleteMission(id);
        return deleted ? new ResponseEntity<>("Mission deleted successfully.", HttpStatus.OK)
                : new ResponseEntity<>("Mission not found.", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{missionId}/addPersonnel/{personnelId}")
    public ResponseEntity<Mission> addPersonnelToMission(@PathVariable Long missionId, @PathVariable Long personnelId) {
        Mission updatedMission = missionService.addPersonnelToMission(missionId, personnelId);
        return new ResponseEntity<>(updatedMission, HttpStatus.OK);
    }

    @DeleteMapping("/{missionId}/removePersonnel/{personnelId}")
    public ResponseEntity<String> removePersonnelFromMission(@PathVariable Long missionId, @PathVariable Long personnelId) {
        boolean removed = missionService.removePersonnelFromMission(missionId, personnelId);

        if (removed) {
            return new ResponseEntity<>("Personnel removed from mission successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Mission or personnel not found.", HttpStatus.NOT_FOUND);
        }
    }
}
