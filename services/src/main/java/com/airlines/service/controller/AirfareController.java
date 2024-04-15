package com.airlines.service.controller;

import com.airlines.service.model.pojo.Airfare;
import com.airlines.service.service.AirfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/airfare")
public class AirfareController {

    @Autowired
    private AirfareService service;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Airfare>> getAll(){
        final List<Airfare> result = service.loadAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Airfare> get(@PathVariable("id") final Long id){
        final Airfare result = service.load(id);

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Airfare> create(@RequestBody final Airfare airfare) {

        final Airfare result = service.create(airfare);

        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<Airfare> update(@RequestBody final Airfare airfare) {

        final Airfare result = service.update(airfare);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
