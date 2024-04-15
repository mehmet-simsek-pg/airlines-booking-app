package com.airlines.service.controller;

import com.airlines.service.model.pojo.Airplane;
import com.airlines.service.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<Airplane>> allAirplanes() {

        final List<Airplane> result = airplaneService.loadAllAirplane();

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Airplane> getAirplane(@PathVariable("id") final Long id) {

        final Airplane airplane = airplaneService.loadAirplaneById(id);

        return ResponseEntity.ok(airplane);
    }

    @PostMapping
    public ResponseEntity<Airplane> createAirplane(@RequestBody final Airplane airplane){

        final Airplane result = airplaneService.createAirplane(airplane);

        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<Airplane> updateAirplane(@RequestBody final Airplane airplane) {

        final Airplane result = airplaneService.updateAirplane(airplane);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removeAirplane(@PathVariable("id") final Long id) {

        airplaneService.deleteAirplane(id);

        return ResponseEntity.noContent().build();
    }
}
