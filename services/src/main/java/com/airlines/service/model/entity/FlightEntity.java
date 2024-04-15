package com.airlines.service.model.entity;

import com.airlines.service.model.pojo.Flight;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "departure", nullable = false)
    private LocalDateTime departure;

    @Column(name = "arrival", nullable = false)
    private LocalDateTime arrival;

    public FlightEntity() {
    }

    public FlightEntity(Long id) {
        this.id = id;
    }

    public FlightEntity(final Flight flight) {
        this.code = flight.getCode();
        this.departure = flight.getDeparture();
        this.arrival = flight.getArrival();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public Flight toFlight() {
        final Flight flight = new Flight();

        flight.setId(getId());
        flight.setCode(getCode());
        flight.setDeparture(getDeparture());
        flight.setArrival(getArrival());

        return flight;
    }
}
