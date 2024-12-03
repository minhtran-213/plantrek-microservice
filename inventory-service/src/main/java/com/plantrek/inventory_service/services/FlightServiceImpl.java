package com.plantrek.inventory_service.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.plantrek.inventory_service.mapper.FlightMapper;
import com.plantrek.inventory_service.models.dtos.requests.FlightRequest;
import com.plantrek.inventory_service.models.entities.FlightEntity;
import com.plantrek.inventory_service.repositories.FlightRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public void addOrUpdateFlight(FlightRequest request) {
        Optional<FlightEntity> optionalFlight = flightRepository
                .findByAirlineAndOriginAndDestination(request.getAirline(), request.getOrigin(),
                        request.getDestination());
        FlightEntity flight = new FlightEntity();
        
        if (optionalFlight.isPresent()) {
            flight = optionalFlight.get();
        }

        flightMapper.updateFlightEntityFromRequest(request, flight);
        flightRepository.save(flight);
    }

}
