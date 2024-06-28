package com.xworkz.issuemanagement.model.service;

import com.xworkz.issuemanagement.dto.SignUpDTO;

import java.time.LocalDateTime;

public interface SignUpService {

    boolean validateAndsave(SignUpDTO signUpDTO);

    void setAudit(SignUpDTO signUpDTO, String createdBy, LocalDateTime createdOn, String updatedBy, LocalDateTime updatedOn, boolean isActive);


    SignUpDTO findByEmailAndPassword(String email, String password);


    //Checking wrong password and Lock the accout
    void incrementFailedAttempts(String email);

    int getFailedAttempts(String email);

    void resetFailedAttempts(String email);

    void lockAccount(String email);
}
