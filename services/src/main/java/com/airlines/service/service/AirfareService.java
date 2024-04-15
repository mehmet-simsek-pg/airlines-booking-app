package com.airlines.service.service;

import com.airlines.service.model.entity.AirfareEntity;
import com.airlines.service.model.pojo.Airfare;
import com.airlines.service.repository.AirfareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirfareService {

    @Autowired
    private AirfareRepository repository;

    public List<Airfare> loadAll() {
        return repository.findAll().stream().map(AirfareEntity::toAirfare).collect(Collectors.toList());
    }

    public Airfare load(final Long id) {
        return repository.findById(id).orElseThrow().toAirfare();
    }

    public Airfare create(final Airfare airfare) {

        AirfareEntity airfareEntity = new AirfareEntity();

        airfareEntity.setCharge_amount(airfare.getCharge_amount());
        airfareEntity.setDescription(airfare.getDescription());

        repository.save(airfareEntity);

        return airfareEntity.toAirfare();
    }

    public Airfare update(final Airfare airfare) {

        AirfareEntity airfareEntity = repository.findById(airfare.getId()).orElseThrow();

        airfareEntity.setCharge_amount(airfare.getCharge_amount());
        airfareEntity.setDescription(airfare.getDescription());

        repository.save(airfareEntity);

        return airfareEntity.toAirfare();
    }

    public void delete(final Long id) {
        AirfareEntity airfareEntity = repository.findById(id).orElseThrow();

        repository.deleteById(id);
    }
}
