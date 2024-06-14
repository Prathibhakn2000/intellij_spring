package com.xworkz.springmvc.model.service;

import com.xworkz.springmvc.dto.TravelFormDTO;
import com.xworkz.springmvc.model.repo.TravelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelServiceImpl implements  TravelService{

    @Autowired
    private TravelRepo travelRepo;
    @Override
    public boolean validateAndSave(TravelFormDTO travelformDTO) {
        boolean save = this.travelRepo.save(travelformDTO);
        if (save) {
            System.out.println("Travel is Save successfully in service" + travelformDTO);

        } else {
            System.out.println("Travel is Not Save Successfully in service" + travelformDTO);

        }
        return true;
    }
}
