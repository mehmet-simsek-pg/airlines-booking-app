package com.airlines.service.service;

import com.airlines.service.model.entity.AirplaneEntity;
import com.airlines.service.model.pojo.Airplane;
import com.airlines.service.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;


    public List<Airplane> loadAllAirplane(){

        return airplaneRepository.findAll().stream().map(AirplaneEntity::toAirplane).collect(Collectors.toList());
    }

    public Airplane loadAirplaneById(final Long id) {

        return airplaneRepository.findById(id).orElseThrow().toAirplane();
    }

    public Airplane createAirplane(final Airplane airplane) {

        final AirplaneEntity airplaneEntity = new AirplaneEntity();
        airplaneEntity.setCapacity(airplane.getCapacity());
        airplaneEntity.setWeight(airplane.getWeight());
        airplaneEntity.setCompany(airplane.getCompany());

        airplaneRepository.save(airplaneEntity);

        return airplaneEntity.toAirplane();
    }

    public Airplane updateAirplane(final Airplane airplane) {

        final AirplaneEntity airplaneEntity = airplaneRepository.findById(airplane.getId()).orElseThrow();

        airplaneEntity.setWeight(airplane.getWeight());
        airplaneEntity.setCapacity(airplane.getCapacity());
        airplaneEntity.setCompany(airplane.getCompany());

        airplaneRepository.save(airplaneEntity);

        return airplaneEntity.toAirplane();
    }

    public void deleteAirplane(final Long id){
        final AirplaneEntity airplaneEntity = airplaneRepository.findById(id).orElseThrow();

        airplaneRepository.deleteById(airplaneEntity.getId());
    }
}
