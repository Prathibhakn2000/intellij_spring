package com.xworkz.springmvc.controller;

import com.xworkz.springmvc.dto.TravelFormDTO;
import com.xworkz.springmvc.model.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.validation.Valid;


    @Controller
    @RequestMapping("/")
    @EnableWebMvc
    public class TravelFormController {
        @Autowired
        private TravelService travelService;

        public TravelFormController()
        {
            System.out.println("Creating TravelFormController");

        }
        @PostMapping("/enjoy")
        public String register(@Valid TravelFormDTO travelformDTO, BindingResult bindingResult, Model model) {
            System.out.println("Running Register to method");
            System.out.println(travelformDTO);

            if (bindingResult.hasErrors()) {
                System.err.println("DTO has invalid Data");
                bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
                model.addAttribute("errors", bindingResult.getAllErrors());
                return "index.jsp";

            } else {
                boolean validate = this.travelService.validateAndSave(travelformDTO);
                if (validate) {
                    System.out.println("Travelform is ValidateAndSave successfully in Controller" + travelformDTO);

                } else {
                    System.out.println("Travelform is Not ValidateAndSave Successfully in Controller" + travelformDTO);

                }

                model.addAttribute("msg", "Thanks For Your FeedBack !!!! " +travelformDTO.getName());


            }
            //model.addAttribute("hi",gymDTO);
            return "TravelMsg.jsp";
        }
    }



