package com.airlines.service.controller;

import com.airlines.service.model.pojo.Passenger;
import com.airlines.service.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/passenger")
public class PassengerController {

    @Autowired
    private PassengerService service;


    @GetMapping(value = "/all")
    public ResponseEntity<List<Passenger>> getAll() {

        final List<Passenger> result = service.loads();

        return ResponseEntity.ok(result);
    }
}
