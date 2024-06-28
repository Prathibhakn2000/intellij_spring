package com.xworkz.issuemanagement.model.repo;

import com.xworkz.issuemanagement.dto.SignUpDTO;

public interface SignUpRepo {

    boolean save(SignUpDTO signUpDTO);

   SignUpDTO findByEmailAndPassword(String email, String password);
}
