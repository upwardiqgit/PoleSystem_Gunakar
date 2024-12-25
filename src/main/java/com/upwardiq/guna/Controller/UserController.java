package com.upwardiq.guna.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.upwardiq.guna.Service.UserService;
import com.upwardiq.guna.Service.VoteService;


@Controller
public class UserController {

	@Autowired
    private UserService service;
    @Autowired
    private VoteService voteservice;

    @GetMapping("/home")
    public String getHomepage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registerpage";
    }
    
}

