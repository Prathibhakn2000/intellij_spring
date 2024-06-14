package com.xworkz.springmvc.model.repo;

import com.xworkz.springmvc.dto.TravelFormDTO;
import org.springframework.stereotype.Repository;

@Repository
public class TravelRepoImpl implements TravelRepo {
    @Override
    public boolean save(TravelFormDTO travelformDTO) {
        return true;
    }
}
