package com.example.project.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.project.Models.Payment;
import com.example.project.project.repositories.PaymentRespositories;



@Controller
@RequestMapping("")
public class Paymentcontroller {
    

    @Autowired
    private PaymentRespositories paymentRespositories;

    @GetMapping("/Payment")
    public ModelAndView addcard(){
        ModelAndView mav = new ModelAndView("Payment.html");
        Payment cardinfo=new Payment();
        mav.addObject("cardinfo", cardinfo);
        return mav;
    }
    @PostMapping("/Payment")
    public String savecard(@ModelAttribute Payment card)
    {
        this.paymentRespositories.save(card);
        return "redirect:/Payment";
     
    }
    
}
