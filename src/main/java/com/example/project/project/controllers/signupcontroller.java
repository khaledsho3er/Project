package com.example.project.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.project.project.Models.User;
import com.example.project.project.repositories.UserRepositories;




@Controller
@RequestMapping("")
public class signupcontroller {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepositories userRepositories;

    @GetMapping("/signup/adduser")
    public ModelAndView Adduser(){
        ModelAndView mav= new ModelAndView("signup.html");
        User newuser=new User();
        mav.addObject("user", newuser);
        return mav;
    }


    @PostMapping("/login/save")
    public String saveuser(@ModelAttribute User user)
    {
        
        String passwordHashed = this.bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passwordHashed);
        this.userRepositories.save(user);
        return "redirect:/login";
    }

   

  

    
}
