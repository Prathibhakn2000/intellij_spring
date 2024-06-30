package com.xworkz.issuemanagement.model.repo;

import com.xworkz.issuemanagement.dto.SignUpDTO;

public interface SignUpRepo {

    boolean save(SignUpDTO signUpDTO);

   SignUpDTO findByEmailAndPassword(String email, String password);

   //count the failed attempts

    SignUpDTO findByEmail(String email); // Add this method to find a user by email


    boolean update(SignUpDTO signUpDto);
}
