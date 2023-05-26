package com.example.project.project.Models;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.hibernate.annotations.GenericGenerator;

@Entity
public class Flights {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String flight_type;
    private String depature_city;
    private String arrival_city;
    private String destination;
    private String departure_date;
    private String price_for_ticket;

  
  
    public Flights()
    {
        
    }
    public Flights(String id, String flight_type, String depature_city, String arrival_city, String destination, String departure_date, String price_for_ticket) {
        this.id = id;
        this.flight_type = flight_type;
        this.depature_city = depature_city;
        this.arrival_city = arrival_city;
        this.destination = destination;
        this.departure_date = departure_date;
        this.price_for_ticket = price_for_ticket;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlight_type() {
        return this.flight_type;
    }

    public void setFlight_type(String flight_type) {
        this.flight_type = flight_type;
    }

    public String getDepature_city() {
        return this.depature_city;
    }

    public void setDepature_city(String depature_city) {
        this.depature_city = depature_city;
    }

    public String getArrival_city() {
        return this.arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture_date() {
        return this.departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getPrice_for_ticket() {
        return this.price_for_ticket;
    }

    public void setPrice_for_ticket(String price_for_ticket) {
        this.price_for_ticket = price_for_ticket;
    }

    
}
