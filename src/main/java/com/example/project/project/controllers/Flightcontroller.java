package com.example.project.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.project.Models.Flights;
import com.example.project.project.repositories.FlightRepositories;


@Controller
@RequestMapping("")
public class Flightcontroller {
 
    @Autowired
    private FlightRepositories FlightRepositories;

    @GetMapping("/flights")
    public ModelAndView flightView()
    {
        ModelAndView mav = new ModelAndView("flights.html");
        List<Flights> flights = FlightRepositories.findAll();
        mav.addObject("flights", flights);
        return mav;
    }

    @GetMapping("/addflights")
    public ModelAndView Addflight()
    {
        ModelAndView mav= new ModelAndView("addflights.html");
        Flights addflight=new Flights();
        mav.addObject("Flights", addflight);
        return mav;
    }
   
    @PostMapping("saveFlights")
    public String saveFlights(@ModelAttribute Flights Flights){
        this.FlightRepositories.save(Flights);
        return "redirect:/flights";
    }
}
