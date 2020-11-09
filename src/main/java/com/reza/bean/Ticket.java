package com.reza.bean;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    Trip trip;
    @ManyToOne(cascade = CascadeType.REFRESH)
    Customer customer;

    public Ticket(Integer id, Trip trip, Customer customer) {
        this.id = id;
        this.trip = trip;
        this.customer = customer;
    }

    public Ticket() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
