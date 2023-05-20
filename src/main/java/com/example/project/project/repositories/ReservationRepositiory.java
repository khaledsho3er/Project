package com.example.project.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.project.Models.Reservation;

@Repository
public interface ReservationRepositiory extends JpaRepository<Reservation, String> {

}
