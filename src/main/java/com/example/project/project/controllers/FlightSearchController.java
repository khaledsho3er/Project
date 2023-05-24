package com.example.project.project.controllers;
import com.example.project.project.Models.Flights;
import com.example.project.project.repositories.FlightRepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class FlightSearchController {

    

    @Autowired
    private FlightRepositories flightRepositories;
    @GetMapping("/flights")
    public ModelAndView search(@RequestParam(name="depature_city", required=false) String depature_city,
    @RequestParam(name="arrival_city", required=false) String arrival_city,
    @RequestParam(name="departure_date", required=false) String departure_date,
    @RequestParam(name="flight_type", required=false) String flight_type) {
        if(depature_city == null && arrival_city == null && departure_date ==  null && flight_type == null)
        {
            ModelAndView mav = new ModelAndView("flights.html");
            List<Flights> flights = flightRepositories.findAll();
            mav.addObject("flights", flights);
            return mav;
            
        }
        
            ModelAndView mav = new ModelAndView(); 
            List<Flights> flights = flightRepositories.findByDepature_cityAndArrival_cityAndDeparture_dateAndFlight_type(depature_city, arrival_city,departure_date,flight_type);
            mav.addObject("flights ", flights );
            return mav;
        
       
    }

}