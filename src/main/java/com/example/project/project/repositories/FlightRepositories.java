package com.example.project.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.project.Models.Flights;

@Repository
public interface FlightRepositories extends JpaRepository<Flights,String> {
    // List<Flights> findAll();
    
}
