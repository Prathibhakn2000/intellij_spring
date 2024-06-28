package com.xworkz.issuemanagement.model.service;

import com.xworkz.issuemanagement.dto.SignUpDTO;
import com.xworkz.issuemanagement.model.repo.SignUpRepo;
import com.xworkz.issuemanagement.util.PassWordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class SignUpServiceImpl implements   SignUpService{
    public SignUpServiceImpl()
    {
        System.out.println("Creating SignUpserviceImpl");
    }

    private Map<String, Integer> failedAttemptsMap = new HashMap<>();
    private Map<String, SignUpDTO> users = new HashMap<>(); // Simulated database

    @Autowired
    private SignUpRepo signUpRepo;
    @Override
    public boolean validateAndsave(SignUpDTO signUpDTO) {
        System.out.println("Running validateAndSave method in SignUpserviceImpl");
        String createdBy = signUpDTO.getFirstName(); // or get the current user
        LocalDateTime createdOn = LocalDateTime.now();
        String updatedBy = signUpDTO.getFirstName(); // or get the current user
        LocalDateTime updatedOn = null;
        users.put(signUpDTO.getEmail(), signUpDTO); // Simulate saving to a database
        boolean isActive = true;

        String generatedPassword = PassWordGenerator.generatePassword();
        signUpDTO.setPassword(generatedPassword);

        setAudit(signUpDTO, createdBy, createdOn, updatedBy, updatedOn, isActive);
      //  boolean res = signUpRepo.save(signUpDTO);

        boolean save = this.signUpRepo.save(signUpDTO);
        if (save) {
            System.out.println("SignUp is Save successfully in service" + signUpDTO);

        } else {
            System.out.println("SignUp is Not Save Successfully in service" + signUpDTO);

        }
        return true;


    }

    @Override
    public void setAudit(SignUpDTO signUpDTO, String createdBy, LocalDateTime createdOn, String updatedBy, LocalDateTime updatedOn, boolean isActive) {
        System.out.println("Running setAudit method....");
        signUpDTO.setCreatedBy(createdBy);

        signUpDTO.setCreatedOn(createdOn);
        signUpDTO.setUpdatedBy(updatedBy);
        signUpDTO.setUpdatedOn(updatedOn);
        signUpDTO.setActive(isActive);
    }


    @Override
    public SignUpDTO findByEmailAndPassword(String email, String password) {
        SignUpDTO user = users.get(email);
        if (user != null && !user.isAccountLocked() && user.getPassword().equals(password)) {
            return user;
        }
        return signUpRepo.findByEmailAndPassword( email, password);
    }

    @Override
    public void incrementFailedAttempts(String email) {
        int attempts = failedAttemptsMap.getOrDefault(email, 0) + 1;
        failedAttemptsMap.put(email, attempts);
        if (attempts >= 3) {
            lockAccount(email);
        }
    }

    @Override
    public int getFailedAttempts(String email) {
        return failedAttemptsMap.getOrDefault(email, 0);
    }

    @Override
    public void resetFailedAttempts(String email) {
        failedAttemptsMap.remove(email);
    }

    @Override
    public void lockAccount(String email) {
        SignUpDTO user = users.get(email);
        if (user != null) {
            user.setAccountLocked(true);
        }
    }

}

