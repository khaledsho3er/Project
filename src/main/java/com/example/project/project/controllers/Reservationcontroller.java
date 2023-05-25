package com.example.project.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.project.Models.Reservation;
import com.example.project.project.Models.User;
import com.example.project.project.Models.Flights;
import com.example.project.project.repositories.ReservationRepositiory;
import com.example.project.project.repositories.FlightRepositories;

@Controller
@RequestMapping("/reservation")
public class Reservationcontroller {
    @Autowired
    private ReservationRepositiory reservationRepositiory;
    @Autowired
    private FlightRepositories flightRepositories;

    @GetMapping("")
    public ModelAndView reservationview(@RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "flight_type", required = false) String flight_type,
            @RequestParam(value = "departure_city", required = false) String departure_city,
            @RequestParam(value = "arrival_city", required = false) String arrival_city,
            @RequestParam(value = "destination", required = false) String destination,
            @RequestParam(value = "departure_date", required = false) String departure_date,
            @RequestParam(value = "price_for_ticket", required = false) String price_for_ticket) {
       

        ModelAndView mav = new ModelAndView("Reservation.html");
        Reservation reservation = new Reservation();
        mav.addObject("reservation", reservation);
        mav.addObject("flight_type", flight_type);
        mav.addObject("arrival_city", arrival_city);
        mav.addObject("destination", destination);
        mav.addObject("departure_date", departure_date);
        mav.addObject("flightId", id);

        List<Flights> flights = flightRepositories.findAll();
        mav.addObject("flights", flights);
        return mav;

    }

    @PostMapping("")
    public String savereserv(@ModelAttribute Reservation reserv, @AuthenticationPrincipal User user,
            @RequestParam(name = "flightId", required = true) String flightId) {

        Flights flight = this.flightRepositories.findById(flightId).orElse(null);

        reserv.setUser(user);
        reserv.setFlights(flight);
        this.reservationRepositiory.save(reserv);
        return "redirect:/Payment?reservationId=" + reserv.getId();
    }

}
