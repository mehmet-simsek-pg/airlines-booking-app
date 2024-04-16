package com.airlines.service.service;

import com.airlines.service.model.entity.AirportEntity;
import com.airlines.service.model.pojo.Airport;
import com.airlines.service.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    @Autowired
    private AirportRepository repository;


    public List<Airport> loads() {

        return repository.findAll().stream().map(AirportEntity::toAirport).collect(Collectors.toList());
    }
}
