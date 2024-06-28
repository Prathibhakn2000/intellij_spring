package com.xworkz.issuemanagement.controller;

import com.xworkz.issuemanagement.dto.SignUpDTO;
import com.xworkz.issuemanagement.model.service.EmailService;
import com.xworkz.issuemanagement.model.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class SignUpController {

    public SignUpController() {
        System.out.println("Creating SignUpController");
    }


    @Autowired
    private SignUpService signUpService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/sign-up")
    public String Register(@Valid SignUpDTO signUpDTO, Model model,@RequestParam("email") String email) {
        System.out.println("Running Register method in SignUpController");
        System.out.println(signUpDTO);

        boolean validate = this.signUpService.validateAndsave(signUpDTO);
        if (validate) {
            System.out.println("SignUp is ValidateAndSave successfully in Controller" + signUpDTO);
            String subject = "Welcome to Our Service";
            String body = "Hi " + signUpDTO.getFirstName()+ ",\n\nYour registration is successful. Your password is " + signUpDTO.getPassword();
            emailService.sendSimpleEmail(email, subject, body);

        } else {
            System.out.println("SignUp is Not ValidateAndSave Successfully in Controller" + signUpDTO);

        }
        model.addAttribute("msg", "successfully SignUp" + signUpDTO.getFirstName());


        return "SignIn";

    }

    @PostMapping("sign-in")
    public String signin(String email, String password, Model model) {
        System.out.println("Running signin method...");
        //System.out.println("Dto Details:" + signinFormDto);

        SignUpDTO signUpDTO = signUpService.findByEmailAndPassword(email, password);
        if (signUpDTO != null) {
            signUpService.resetFailedAttempts(email);
            model.addAttribute("msg1", "successfully logined with:" + signUpDTO.getEmail());
            return "SignIn";
        } else {
            signUpService.incrementFailedAttempts(email);
            int failedAttempts = signUpService.getFailedAttempts(email);
            System.out.println("Failed attempts for " + email + ": " + failedAttempts);

            if (failedAttempts >= 3) {
                signUpService.lockAccount(email); // Lock account after 3 failed attempts
                model.addAttribute("error", "Your account is locked due to too many failed attempts.");
                model.addAttribute("accountLocked", true);
            } else {
                model.addAttribute("error", "Invalid email id and password. Attempts: " + failedAttempts);
                model.addAttribute("accountLocked", false);
            }
            //model.addAttribute("error", "Invalid email id and password");
            return "SignIn";
        }
    }
}
