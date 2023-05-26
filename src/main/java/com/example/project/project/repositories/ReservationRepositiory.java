package com.example.project.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.project.Models.Flights;
import com.example.project.project.Models.Reservation;
import com.example.project.project.Models.User;

@Repository
public interface ReservationRepositiory extends JpaRepository<Reservation, String> {
    public Optional<Reservation> findById(String id);
    public Optional<Reservation> findByFlights(Flights flights);
    public List<Reservation> findByUser(User user);
}