package com.example.project.project.Models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    private String src;
    private String dst;
    private Date date;
    private int adults;
    private int children;
    private int travelclass;

    @ManyToOne
    private User user;

    public Reservation() {
    }

    public Reservation(String id, String src, String dst, Date date, int adults, int children, int travelclass) {
        this.id = id;
        this.src = src;
        this.dst = dst;
        this.date = date;
        this.adults = adults;
        this.children = children;
        this.travelclass = travelclass;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSrc() {
        return this.src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return this.dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getTravelclass() {
        return this.travelclass;
    }

    public void setTravelclass(int travelclass) {
        this.travelclass = travelclass;
    }

    public Reservation id(String id) {
        setId(id);
        return this;
    }

    public Reservation src(String src) {
        setSrc(src);
        return this;
    }

    public Reservation dst(String dst) {
        setDst(dst);
        return this;
    }

    public Reservation date(Date date) {
        setDate(date);
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

    public Reservation travelclass(int travelclass) {
        setTravelclass(travelclass);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Reservation)) {
            return false;
        }
        Reservation reservation = (Reservation) o;
        return Objects.equals(id, reservation.id) && Objects.equals(src, reservation.src)
                && Objects.equals(dst, reservation.dst) && Objects.equals(date, reservation.date)
                && adults == reservation.adults && children == reservation.children
                && travelclass == reservation.travelclass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, src, dst, date, adults, children, travelclass);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", src='" + getSrc() + "'" +
                ", dst='" + getDst() + "'" +
                ", date='" + getDate() + "'" +
                ", adults='" + getAdults() + "'" +
                ", children='" + getChildren() + "'" +
                ", travelclass='" + getTravelclass() + "'" +
                "}";
    }

}
