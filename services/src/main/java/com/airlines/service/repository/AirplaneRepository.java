package com.airlines.service.repository;

import com.airlines.service.model.entity.AirplaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<AirplaneEntity, Long> {
}
