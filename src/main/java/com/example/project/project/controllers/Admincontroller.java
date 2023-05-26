package com.example.project.project.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.project.project.Models.Flights;
import com.example.project.project.repositories.FlightRepositories;
import com.example.project.project.Models.User;
import com.example.project.project.repositories.UserRepositories;

@Controller
public class Admincontroller {
    @Autowired
      private FlightRepositories FlightRepositories;

      @Autowired
      private UserRepositories UserRepositories;

    @GetMapping("/admin")
    public ModelAndView gethome()
    {
        ModelAndView mav = new ModelAndView("Admin.html");
        return mav;
    }
     @GetMapping("/admin-view-flights")
    public ModelAndView getadminviewflights()
    {
        ModelAndView mav = new ModelAndView("admin-view-flights.html");
        List<Flights> flights = FlightRepositories.findAll();
            mav.addObject("flight", flights);
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

    
}