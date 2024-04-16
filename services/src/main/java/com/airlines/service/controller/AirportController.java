package com.airlines.service.controller;

import com.airlines.service.model.pojo.Airport;
import com.airlines.service.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/airport")
public class AirportController {

    @Autowired
    private AirportService service;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Airport>> getAll(){

        final List<Airport> result = service.loads();

        return ResponseEntity.ok(result);
    }
}
