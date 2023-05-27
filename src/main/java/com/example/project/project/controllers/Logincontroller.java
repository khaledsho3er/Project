package com.example.project.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.project.Models.User;
import com.example.project.project.Services.AuthService;
import com.example.project.project.repositories.UserRepositories;

@Controller
@RequestMapping("")
public class Logincontroller {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public ModelAndView getloginform(){
        ModelAndView mav = new ModelAndView("login.html");
        User user= new User();
        mav.addObject("user", user);
        return mav;
    }


    @PostMapping("/login/home")
    public String login(@ModelAttribute User user)
    {
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),user.getAuthorities());
         
       Authentication authenticated = this.authService.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authenticated);

       
        return "redirect:/home";
    }

    @GetMapping("/home")
    public ModelAndView gethome()
    {
        ModelAndView mav = new ModelAndView("home.html");
        return mav;
    }
   
    @GetMapping("/contactus")
    public ModelAndView getContactUs()
    {
        ModelAndView mav = new ModelAndView("contactus.html");
        return mav;
    }
}
