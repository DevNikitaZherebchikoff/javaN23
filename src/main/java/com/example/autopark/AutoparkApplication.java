package com.example.autopark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
public class AutoparkApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AutoparkApplication.class, args);
    }

}