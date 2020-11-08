package com.reza.bean;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
public class Trip {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String originCity;
    String destinationCity;
    LocalTime moveTime;
    LocalDate moveDate;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    Set<Ticket> soldTickets;

    public Trip(Integer id, String originCity, String destinationCity, LocalTime moveTime, LocalDate moveDate, Set<Ticket> availableTickets) {
        this.id = id;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.moveTime = moveTime;
        this.moveDate = moveDate;
        this.soldTickets = availableTickets;
    }

    public Trip() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public LocalTime getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(LocalTime moveTime) {
        this.moveTime = moveTime;
    }

    public LocalDate getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(LocalDate moveDate) {
        this.moveDate = moveDate;
    }

    public Set<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(Set<Ticket> availableTickets) {
        this.soldTickets = availableTickets;
    }
}

