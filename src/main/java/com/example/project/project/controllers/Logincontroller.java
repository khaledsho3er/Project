package com.example.project.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.project.repositories.UserRepositories;

@Controller
@RequestMapping("")
public class Logincontroller {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepositories userRepositories;

    @PostMapping("/home")
    public ModelAndView login(){
        ModelAndView mav= new ModelAndView("home.html");
        return mav;

    }

    @GetMapping("/home")
    public ModelAndView loginG(){
        ModelAndView mav= new ModelAndView("home.html");
        return mav;

    }

    
    
}
