package com.example.project.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.project.Models.Payment;
import com.example.project.project.Models.Reservation;
import com.example.project.project.repositories.PaymentRespositories;
import com.example.project.project.repositories.ReservationRepositiory;

@Controller
@RequestMapping("")
public class Paymentcontroller {
    @Autowired
    private ReservationRepositiory reservationRepositiory;

    @Autowired
    private PaymentRespositories paymentRespositories;

    @GetMapping("/Payment")
    public ModelAndView addcard(@RequestParam(value = "reservationId", required = false) String reservationId) {
        Reservation reservation = this.reservationRepositiory.findById(reservationId).orElse(null);
        double price = (reservation.getAdults() * (Double.parseDouble(reservation.getFlights().getPrice_for_ticket())))
                + (reservation.getChildren() * (Double.parseDouble(reservation.getFlights().getPrice_for_ticket()))
                        * 0.5);
        ModelAndView mav = new ModelAndView("Payment.html");
        Payment cardinfo = new Payment();
        mav.addObject("cardinfo", cardinfo);
        mav.addObject("price", price);
        return mav;
    }

    @PostMapping("/Payment")
    public String savecard(@ModelAttribute Payment card, @RequestParam(name = "price", required = true) Double price) {
        card.setAmount(price.intValue());
        this.paymentRespositories.save(card);
        return "redirect:/home";

    }
}
