package com.plantrek.inventory_service.repositories;

import com.plantrek.inventory_service.models.entities.FlightScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightScheduleRepository extends JpaRepository<FlightScheduleEntity, String> {

}
