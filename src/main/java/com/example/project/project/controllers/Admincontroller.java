package com.example.project.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Admincontroller {
    

    @GetMapping("/admin")
    public ModelAndView gethome()
    {
        ModelAndView mav = new ModelAndView("Admin.html");
        return mav;
    }
    
}
