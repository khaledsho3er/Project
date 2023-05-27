package com.example.project.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.project.Models.Flights;
import com.example.project.project.Models.Reservation;
import com.example.project.project.Models.User;
import com.example.project.project.repositories.ReservationRepositiory;
import com.example.project.project.repositories.FlightRepositories;

@Controller
public class userprofileController {
    @Autowired
    private FlightRepositories FlightRepositories;
    @Autowired
    private ReservationRepositiory reservationRepositiory;
    
   
    @GetMapping("/userprofile")
    public ModelAndView profileform(@AuthenticationPrincipal User user){

        ModelAndView mav = new ModelAndView("userprofile.html");

       List <Reservation> resv = reservationRepositiory.findByUser(user);
       mav.addObject("reservations", resv);


        return mav;
    }

    @GetMapping("/delete-reservation")
    public String getdeletereservation(@RequestParam String id)
    {
        this.reservationRepositiory.deleteById(id);
        return "redirect:/userprofile";
    }
       

    // @PostMapping("/userprofile")
    // public String savereserv(@ModelAttribute Flights flight, @AuthenticationPrincipal User user,
    //         @RequestParam(name = "flightId", required = true) String flightId) {

    //     Flights flight = this.FlightRepositories.findById(flightId).orElse(null);

    //     reserv.setUser(user);
    //     reserv.setFlights(flight);
    //     this.reservationRepositiory.save(reserv);
    //     return "redirect:/Payment?reservationId=" + reserv.getId();
    // }

}