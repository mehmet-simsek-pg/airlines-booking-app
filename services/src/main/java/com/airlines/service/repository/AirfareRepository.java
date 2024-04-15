package com.airlines.service.repository;

import com.airlines.service.model.entity.AirfareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirfareRepository extends JpaRepository<AirfareEntity, Long> {
}
