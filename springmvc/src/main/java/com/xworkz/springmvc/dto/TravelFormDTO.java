package com.xworkz.springmvc.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

    public class TravelFormDTO {
        @NotNull(message = "Name cannot be Null")
        @Size(min=3,max=30,message = "Name Should be min 3 and max 30")
        @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should contain only alphabetic characters")
        private  String  name;
        @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
        private  String  phone;

        @NotEmpty(message = "Email cannot be empty")
//    @Email(message = "Enter valid email")
        @Pattern(regexp = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "Enter valid email")
        private  String  email;
        @NotNull(message = "Tour cannot be Null")
        private  String  tour;
        @NotNull(message = "Service cannot be Null")
        @Size(min=3,max=30,message = "Service Should be min 3 and max 30")
        @Pattern(regexp = "^[a-zA-Z]+$", message = "Service should contain only alphabetic characters")
        private  String  service;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTour() {
            return tour;
        }

        public void setTour(String tour) {
            this.tour = tour;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        @Override
        public String toString() {
            return "TravelDTO{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    ", tour='" + tour + '\'' +
                    ", service='" + service + '\'' +
                    '}';
        }
    }


