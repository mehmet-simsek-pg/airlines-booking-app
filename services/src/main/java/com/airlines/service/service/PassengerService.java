package com.airlines.service.service;

import com.airlines.service.model.entity.PassengerEntity;
import com.airlines.service.model.pojo.Passenger;

import com.airlines.service.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository repository;

    public List<Passenger> loads() {

        return repository.findAll().stream().map(PassengerEntity::toPassenger).collect(Collectors.toList());
    }
}
