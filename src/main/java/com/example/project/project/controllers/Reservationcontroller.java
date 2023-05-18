package com.example.project.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.project.Models.Reservation;
import com.example.project.project.repositories.ReservationRepositiory;

@Controller
@RequestMapping("/reservation")
public class Reservationcontroller {
    @Autowired
    private ReservationRepositiory reservationRepositiory;

    @GetMapping("")
    public ModelAndView loginview() {
        ModelAndView mav = new ModelAndView("Reservation.html");
        Reservation reservation = new Reservation();
        mav.addObject("reservation", reservation);
        return mav;

    }

    @PostMapping("")
    public String savereserv(@ModelAttribute Reservation reserv) {
        // reserv.setUser(user);
        this.reservationRepositiory.save(reserv);
        return "redirect:/login";
    }

}
