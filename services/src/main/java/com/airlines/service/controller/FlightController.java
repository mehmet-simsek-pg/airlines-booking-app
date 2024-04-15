package com.airlines.service.controller;

import com.airlines.service.model.pojo.Flight;
import com.airlines.service.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/flight")
public class FlightController {

    @Autowired
    private FlightService service;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Flight>> getAll() {

        final List<Flight> flights = service.loadAll();

        return ResponseEntity.ok(flights);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> get(@PathVariable("id") final Long id) {

        final Flight flight = service.load(id);

        return ResponseEntity.ok(flight);
    }

    @PostMapping
    public ResponseEntity<Flight> create(@RequestBody final Flight flight) {

        Flight result = service.create(flight);

        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<Flight> update(@RequestBody final Flight flight) {

        final Flight result = service.update(flight);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") final Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
