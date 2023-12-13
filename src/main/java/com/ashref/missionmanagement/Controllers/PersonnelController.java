package com.ashref.missionmanagement.Controllers;

import com.ashref.missionmanagement.Models.Personnel;
import com.ashref.missionmanagement.Services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    @GetMapping
    public ResponseEntity<List<Personnel>> getAllPersonnel() {
        List<Personnel> personnelList = personnelService.getAllPersonnel();
        return new ResponseEntity<>(personnelList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personnel> getPersonnelById(@PathVariable Long id) {
        Personnel personnel = personnelService.getPersonnelById(id);
        return personnel != null ? new ResponseEntity<>(personnel, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addPersonnel(@RequestBody Personnel personnel) {
        personnelService.addPersonnel(personnel);
        return new ResponseEntity<>("Personnel added successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePersonnel(@PathVariable Long id, @RequestBody Personnel personnel) {
        boolean updated = personnelService.updatePersonnel(id, personnel);
        return updated ? new ResponseEntity<String>("Personnel updated successfully.", HttpStatus.OK) : new ResponseEntity<>("Personnel not found.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonnel(@PathVariable Long id) {
        boolean deleted = personnelService.deletePersonnel(id);
        return deleted ? new ResponseEntity<>("Personnel deleted successfully.", HttpStatus.OK) : new ResponseEntity<>("Personnel not found.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/school")
    public ResponseEntity<List<Personnel>> getPersonnelBySchool(@RequestParam("schoolName") String schoolName) {
        List<Personnel> personnelList = personnelService.getPersonnelBySchool(schoolName);
        HttpStatus status = personnelList.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(personnelList, status);
    }

}
