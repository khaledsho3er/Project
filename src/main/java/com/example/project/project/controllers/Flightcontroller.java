package com.example.project.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.project.Models.Flights;
import com.example.project.project.repositories.FlightRepositories;


@Controller
@RequestMapping("")
public class Flightcontroller {
 
    @Autowired
    private FlightRepositories FlightRepositories;
 

    @GetMapping("/flights")
    public ModelAndView search(@RequestParam(name="depature_city", required=false) String depature_city,
    @RequestParam(name="arrival_city", required=false) String arrival_city,
    @RequestParam(name="departure_date", required=false) String departure_date,
    @RequestParam(name="id", required=false) String id,
    @RequestParam(name="destination", required=false) String destination,
    @RequestParam(name="flight_type", required=false) String flight_type,
    @RequestParam(name="price_for_ticket", required=false) String price_for_ticket) {
        if(depature_city == null && arrival_city == null && departure_date ==  null && flight_type == null)
        {
            ModelAndView mav = new ModelAndView("flights.html");
            List<Flights> flights = FlightRepositories.findAll();
            mav.addObject("flights", flights);
            return mav;
            
        }
        else{
            ModelAndView mav = new ModelAndView("flights.html"); 
            List<Flights> flights = FlightRepositories.findByDepature_cityAndArrival_cityAndDeparture_dateAndFlight_type(depature_city, arrival_city,departure_date,flight_type);
            mav.addObject("flights", flights );
            mav.addObject("flight_type", flight_type);
            mav.addObject("id", id);
            mav.addObject("depature_city", depature_city);
            mav.addObject("arrival_city", arrival_city);
            mav.addObject("destination", destination);
            mav.addObject("price_for_ticket", price_for_ticket);
            mav.addObject("departure_date", departure_date);
            return mav;
        }
       
    }

    // @GetMapping("/addflights")
    // public ModelAndView Addflight()
    // {
    //     ModelAndView mav= new ModelAndView("addflights.html");
    //     Flights addflight=new Flights();
    //     mav.addObject("Flights", addflight);
    //     return mav;
    // }
   
    // @PostMapping("saveFlights")
    // public String saveFlights(@ModelAttribute Flights Flights){
    //     this.FlightRepositories.save(Flights);
    //     return "redirect:/flights";
    // }
    @GetMapping("/flightsss")
    public ResponseEntity getFlights(@RequestParam(name="depature_city", required=false) String depature_city,
    @RequestParam(name="arrival_city", required=false) String arrival_city,
    @RequestParam(name="departure_date", required=false) String departure_date,
    @RequestParam(name="id", required=false) String id,
    @RequestParam(name="destination", required=false) String destination,
    @RequestParam(name="flight_type", required=false) String flight_type) throws Exception{
        if(depature_city != null && depature_city.equals("ERROR")||departure_date!=null &&departure_date.equals("ERRRO")||arrival_city != null && arrival_city.equals("ERROR")||flight_type!=null &&flight_type.equals("ERRRO")){
            throw new Exception("User passed ERROR as a parameter");
        }
        List<Flights> flights;
        if(depature_city == null||departure_date==null||arrival_city==null||flight_type==null)
        flights = this.FlightRepositories.findAll(); // fetching all posts from the database
        else{
            return null;
        }
        // <Flights> flights = FlightRepositories.findByDepature_cityAndArrival_cityAndDeparture_dateAndFlight_type(depature_city, arrival_city,departure_date,flight_type);        
        return new ResponseEntity(flights, HttpStatus.OK); // returning the posts with HttpStatus.OK status
    }
}
