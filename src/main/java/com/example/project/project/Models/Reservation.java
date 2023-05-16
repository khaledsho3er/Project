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
    private Date depdate;
    private Date retdate;
    private int adults;
    private int children;
    private int travelclass;

    @ManyToOne
    private User user;

    public Reservation() {
    }

    public Reservation(String id, String src, String dst, Date depdate, Date retdate, int adults, int children,
            int travelclass) {
        this.id = id;
        this.src = src;
        this.dst = dst;
        this.depdate = depdate;
        this.retdate = retdate;
        this.adults = adults;
        this.children = children;
        this.travelclass = travelclass;
    }

    public Reservation(String id, String src, String dst, Date depdate, Date retdate, int adults, int children,
            int travelclass, User user) {
        this.id = id;
        this.src = src;
        this.dst = dst;
        this.depdate = depdate;
        this.retdate = retdate;
        this.adults = adults;
        this.children = children;
        this.travelclass = travelclass;
        this.user = user;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getDepdate() {
        return this.depdate;
    }

    public void setDepdate(Date depdate) {
        this.depdate = depdate;
    }

    public Date getRetdate() {
        return this.retdate;
    }

    public void setRetdate(Date retdate) {
        this.retdate = retdate;
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

    public Reservation src(String src) {
        setSrc(src);
        return this;
    }

    public Reservation dst(String dst) {
        setDst(dst);
        return this;
    }

    public Reservation depdate(Date depdate) {
        setDepdate(depdate);
        return this;
    }

    public Reservation retdate(Date retdate) {
        setRetdate(retdate);
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

    public Reservation user(User user) {
        setUser(user);
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
                && Objects.equals(dst, reservation.dst) && Objects.equals(depdate, reservation.depdate)
                && Objects.equals(retdate, reservation.retdate) && adults == reservation.adults
                && children == reservation.children && travelclass == reservation.travelclass
                && Objects.equals(user, reservation.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, src, dst, depdate, retdate, adults, children, travelclass, user);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", src='" + getSrc() + "'" +
                ", dst='" + getDst() + "'" +
                ", depdate='" + getDepdate() + "'" +
                ", retdate='" + getRetdate() + "'" +
                ", adults='" + getAdults() + "'" +
                ", children='" + getChildren() + "'" +
                ", travelclass='" + getTravelclass() + "'" +
                ", user='" + getUser() + "'" +
                "}";
    }

}
