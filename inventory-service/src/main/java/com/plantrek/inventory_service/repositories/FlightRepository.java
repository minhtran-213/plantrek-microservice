package com.plantrek.inventory_service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plantrek.inventory_service.models.entities.FlightEntity;

public interface FlightRepository extends JpaRepository<FlightEntity, String >{
    Optional<FlightEntity> findByAirlineAndOriginAndDestination(String airline, String origin, String destination);
}
