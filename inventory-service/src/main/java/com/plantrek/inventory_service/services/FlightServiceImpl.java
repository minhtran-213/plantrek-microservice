package com.plantrek.inventory_service.services;

import com.plantrek.inventory_service.mapper.FlightMapper;
import com.plantrek.inventory_service.models.dtos.requests.FlightRequest;
import com.plantrek.inventory_service.models.entities.FlightEntity;
import com.plantrek.inventory_service.repositories.FlightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public void addOrUpdateFlight(FlightRequest request) {
        Optional<FlightEntity> optionalFlight = flightRepository
                .findByAirlineAndOriginAndDestination(request.getAirline(), request.getOrigin(),
                        request.getDestination());
        FlightEntity flight;

        if (optionalFlight.isPresent()) {
            flight = optionalFlight.get();
            log.info("Existing flight found with id: {}", flight.getId());
            flightMapper.updateFlightEntityFromRequest(request, flight);
        } else {
            flight = flightMapper.flightRequestToFlightEntity(request);
        }

        flightRepository.save(flight);
    }

}
