package com.example.project.project.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import java.util.Objects;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private int adults;
    private int children;

    @ManyToOne
    private Flights flights;

    @ManyToOne
    private User user;

    @Enumerated(value = EnumType.STRING)
    private Status status = Status.pending;


    public Reservation() {
        
    }

    public Reservation(String id, int adults, int children, Flights flights, User user) {
        this.id = id;
        this.adults = adults;
        this.children = children;
        this.flights = flights;
        this.user = user;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAdults() {
        return this.adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return this.children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Flights getFlights() {
        return this.flights;
    }

    public void setFlights(Flights flights) {
        this.flights = flights;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation id(String id) {
        setId(id);
        return this;
    }

    public Reservation adults(int adults) {
        setAdults(adults);
        return this;
    }

    public Reservation children(int children) {
        setChildren(children);
        return this;
    }

    public Reservation flights(Flights flights) {
        setFlights(flights);
        return this;
    }

    public Reservation user(User user) {
        setUser(user);
        return this;
    }

    
    public Status getStatus() {
        return status= Status.Approved;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Reservation)) {
            return false;
        }
        Reservation reservation = (Reservation) o;
        return Objects.equals(id, reservation.id) && adults == reservation.adults && children == reservation.children
                && Objects.equals(flights, reservation.flights) && Objects.equals(user, reservation.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adults, children, flights, user);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", adults='" + getAdults() + "'" +
                ", children='" + getChildren() + "'" +
                ", flights='" + getFlights() + "'" +
                ", user='" + getUser() + "'" +
                "}";
    }

}
