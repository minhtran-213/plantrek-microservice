package com.plantrek.inventory_service.repositories;

import com.plantrek.inventory_service.models.entities.FlightScheduleEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightScheduleRepository extends JpaRepository<FlightScheduleEntity, String> {

    List<FlightScheduleEntity> findByFlightId(String flightId);
}
