package com.example.project.project.controllers;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.project.Models.Flights;
import com.example.project.project.repositories.FlightRepositories;


@RestController
@RequestMapping("")
public class addflightsController {

    
    @Autowired
    private FlightRepositories FlightRepositories;

    @GetMapping("/addflights")
    public ModelAndView Addflight()
    {
        ModelAndView mav= new ModelAndView("addflights.html");
        Flights addflight=new Flights();
        mav.addObject("Flights", addflight);
        return mav;
    }
    @GetMapping("/viewflights")
    public ModelAndView viewflight()
    {
        ModelAndView mav= new ModelAndView("viewflights.html");
        List<Flights> flights = FlightRepositories.findAll();
        mav.addObject("flights", flights);
        return mav;
    }
    // @GetMapping("/updateFlight")
    // public ModelAndView getupdateFlight(@RequestParam(value = "id", required = false) String id, 
    // @RequestParam(value = "flight_type", required = false) String flight_type,
    // @RequestParam(value = "departure_city", required = false) String departure_city,
    // @RequestParam(value = "arrival_city", required = false) String arrival_city,
    // @RequestParam(value = "destination", required = false) String destination,
    // @RequestParam(value = "departure_date", required = false) String departure_date,
    // @RequestParam(value = "price_for_ticket", required = false) String price_for_ticket){
    //         System.out.println(id);
    //         System.out.println(flight_type);
    //         System.out.println(arrival_city);
    //         System.out.println(destination);
    //         System.out.println(departure_date);
    //         System.out.println(price_for_ticket);
    //     ModelAndView mav =new ModelAndView("addflights.html");
    //     Flights oldFlight = this.FlightRepositories.findById(id).orElse(null);
    //     mav.addObject(id, oldFlight);
    //     return mav;

    // }
    @GetMapping("/updateFlight")
    public ModelAndView updateFlight(@RequestParam(value = "id", required = false) String id,
    @RequestParam(value = "flight_type", required = false) String flight_type,
    @RequestParam(value = "departure_city", required = false) String departure_city,
    @RequestParam(value = "arrival_city", required = false) String arrival_city,
    @RequestParam(value = "destination", required = false) String destination,
    @RequestParam(value = "departure_date", required = false) String departure_date,
    @RequestParam(value = "price_for_ticket", required = false) String price_for_ticket) {
        System.out.println(id);
        System.out.println(flight_type);
        System.out.println(arrival_city);
        System.out.println(departure_city);
        System.out.println(destination);
        System.out.println(departure_date);
        System.out.println(price_for_ticket);

        ModelAndView mav = new ModelAndView("updateflight.html");
        Flights updateflight = new Flights();
        mav.addObject("updateflight", updateflight);
        mav.addObject("flight_type", flight_type);
        mav.addObject("arrival_city", arrival_city);
        mav.addObject("departure_city", departure_city);
        mav.addObject("destination", destination);
        mav.addObject("departure_date", departure_date);
        mav.addObject("price_for_ticket",price_for_ticket);
        mav.addObject("flightId", id);

    Flights oldFlight = this.FlightRepositories.findById(id).orElse(null);
    //List<Flights> oldFlight = this.FlightRepositories.findAll();

        mav.addObject("flights", oldFlight);
        return mav;
    }
// @GetMapping("/update")
// public ModelAndView getupdate(@RequestParam(value = "id", required = false) String id)
// {
//     ModelAndView mav=new ModelAndView("updateflight.html");
//     Flights update=this.FlightRepositories.findById((String)id).orElse(null);
//     mav.addObject("flights", update);
//     return mav;
// }
//     // @PostMapping("/flights/save")
    // public ResponseEntity<?> createPost(@RequestBody Map<String, String> body) {
    // try {
    //     Flights newFlight = new Flights();
    //     newFlight.setFlight_type(body.get("flight_type"));
    //     newFlight.setDepature_city(body.get("depature_city"));
    //     newFlight.setArrival_city(body.get("arrival_city"));
    //     newFlight.setDestination(body.get("destination"));
    //     newFlight.setDeparture_date(body.get("departure_date"));
    //     newFlight.setPrice_for_ticket(body.get("price_for_ticket"));
        
    //     Flights savedFlight = FlightRepositories.save(newFlight);
    //     return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    // } catch (Exception e) {
    //     return new ResponseEntity<>("Error saving flight: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    // }
 
    // @PostMapping("/flights/save")
    // public  ResponseEntity createPost(@RequestBody Map<String,String> body)
    // {
    //      Flights newflights=new Flights();
    //      this.FlightRepositories.save(newflights);
    //     return new ResponseEntity(newflights, HttpStatus.CREATED);
    // }
    //----------works------------
    @PostMapping("/flights/save")
    public String saveFlights(@ModelAttribute Flights Flights){
        this.FlightRepositories.save(Flights);
        return "redirect:/viewflights";
    }
}
