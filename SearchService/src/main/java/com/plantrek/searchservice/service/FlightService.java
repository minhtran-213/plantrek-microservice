package com.plantrek.searchservice.service;

import org.springframework.stereotype.Service;

import com.plantrek.searchservice.models.dtos.requests.FlightSearchRequest;

@Service
public class FlightService {

    public boolean checkFlight(FlightSearchRequest request) {
        String flightCode = request.getFlightCode();
        return flightCode != null;
    }
}
