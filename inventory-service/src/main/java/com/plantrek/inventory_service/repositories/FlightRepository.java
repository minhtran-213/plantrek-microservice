package com.plantrek.inventory_service.repositories;

import com.plantrek.inventory_service.models.entities.FlightEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<FlightEntity, String> {
    Optional<FlightEntity> findByAirlineAndOriginAndDestination(String airline, String origin, String destination);

    Page<FlightEntity> findAll(Specification<FlightEntity> specification, Pageable pageable);
}
