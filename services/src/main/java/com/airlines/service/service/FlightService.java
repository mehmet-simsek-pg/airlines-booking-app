package com.airlines.service.service;

import com.airlines.service.model.entity.FlightEntity;
import com.airlines.service.model.pojo.Flight;
import com.airlines.service.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public List<Flight> loadAll() {

        return repository.findAll().stream().map(FlightEntity::toFlight).collect(Collectors.toList());
    }

    public Flight load(final Long id) {
        return repository.findById(id).orElseThrow().toFlight();
    }

    public Flight create(final Flight flight) {

        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setCode(flight.getCode());
        flightEntity.setDeparture(flight.getDeparture());
        flightEntity.setArrival(flight.getArrival());

        repository.save(flightEntity);

        return flightEntity.toFlight();
    }

    public Flight update(final Flight flight) {

        FlightEntity flightEntity = repository.findById(flight.getId()).orElseThrow();
        flightEntity.setCode(flight.getCode());
        flightEntity.setDeparture(flight.getDeparture());
        flightEntity.setArrival(flight.getArrival());

        repository.save(flightEntity);

        return flightEntity.toFlight();
    }

    public void delete(final Long id){
        FlightEntity flightEntity = repository.findById(id).orElseThrow();

        repository.delete(flightEntity);

    }

}
