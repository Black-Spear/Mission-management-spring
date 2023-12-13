package com.ashref.missionmanagement.Services;

import com.ashref.missionmanagement.Models.Personnel;
import com.ashref.missionmanagement.Repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelService {

    @Autowired
    private PersonnelRepository personnelRepository;

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    public Personnel getPersonnelById(Long id) {
        return personnelRepository.findById(id).orElse(null);
    }

    public void addPersonnel(Personnel personnel) {
        personnelRepository.save(personnel);
    }

    public boolean updatePersonnel(Long id, Personnel updatedPersonnel) {
        Optional<Personnel> existingPersonnel = personnelRepository.findById(id);
        if (existingPersonnel.isPresent()) {
            Personnel personnelToUpdate = existingPersonnel.get();
            personnelToUpdate.setName(updatedPersonnel.getName());
            personnelToUpdate.setSurname(updatedPersonnel.getSurname());
            personnelToUpdate.setContactInformation(updatedPersonnel.getContactInformation());
            personnelToUpdate.setAddress(updatedPersonnel.getAddress());

            personnelRepository.save(personnelToUpdate);

            return true;
        }
        return false;
    }

    public boolean deletePersonnel(Long id) {
        Optional<Personnel> personnelOptional = personnelRepository.findById(id);

        if (personnelOptional.isPresent()) {
            personnelRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Personnel> getPersonnelBySchool(String schoolName) {
        return personnelRepository.findByEducationListSchool(schoolName);
    }


}
