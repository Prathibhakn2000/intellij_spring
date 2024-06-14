package com.xworkz.springmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.springmvc")
@PropertySource("classpath:application.properties")
//@EnableWebMvc
public class SpringmvcConfig {

    public SpringmvcConfig()
    {
        System.out.println("Created SpringmvcConfiguration");
    }

}
