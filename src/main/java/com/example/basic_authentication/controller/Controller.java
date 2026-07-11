package com.example.basic_authentication.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/greeting")
    public String greeting(Authentication authentication){
        // Inject Authentication object inside the method
        // easy to extract log-in user credentials using authentication object
        String username = authentication.getName(); // stores log-in username

        return "welcome " + username;
    }

}
