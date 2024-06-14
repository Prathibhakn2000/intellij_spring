package com.xworkz.springmvc.model.service;

import com.xworkz.springmvc.dto.TravelFormDTO;


public interface TravelService {

    public boolean validateAndSave(TravelFormDTO travelformDTO);
}


