package com.example.project.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.project.project.Models.Flights;
import com.example.project.project.repositories.FlightRepositories;
import com.example.project.project.Models.User;
import com.example.project.project.repositories.UserRepositories;

@Controller
@RequestMapping("/admin")
public class Admincontroller {

    @Autowired
      private FlightRepositories FlightRepositories;

      @Autowired
      private UserRepositories UserRepositories;

    @GetMapping("")
    public ModelAndView gethome()
    {
        ModelAndView mav = new ModelAndView("Admin.html");
        return mav;
    }

    @GetMapping("/admin-viewflights")
    public ModelAndView viewflight()
    {
        ModelAndView mav= new ModelAndView("viewflights.html");
        List<Flights> flights = FlightRepositories.findAll();
        mav.addObject("flights", flights);
        return mav;
    }

        @GetMapping("/admin-view-users")
        public ModelAndView getadminviewusers()
        {
            ModelAndView mav = new ModelAndView("admin-view-users.html");
            List<User> user = UserRepositories.findAll();
                mav.addObject("user", user);
                return mav;
        }  
        // @GetMapping("/admin-addflights")
        // public ModelAndView Addflight()
        // {
        //     ModelAndView mav= new ModelAndView("addflights.html");
        //     Flights addflight=new Flights();
        //     mav.addObject("Flights", addflight);
        //     return mav;
        // }
        @GetMapping("/admin-addflights")
        public ModelAndView Addflight()
        {
            ModelAndView mav= new ModelAndView("addflights.html");
            Flights addflight=new Flights();
            mav.addObject("Flights", addflight);
            return mav;
        }
        @GetMapping("/admin-updateFlight")
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
    @GetMapping("/delete-flight")
    public String getdeleteflight(@RequestParam String flightID)
    {
        this.FlightRepositories.deleteById(flightID);
        return "redirect:/admin/admin-viewflights";

    }
    @PostMapping("/admin-flights-save")
    public String saveFlights(@ModelAttribute Flights Flights){
        this.FlightRepositories.save(Flights);
        return "redirect:/admin/admin-viewflights";
    }

    


}
