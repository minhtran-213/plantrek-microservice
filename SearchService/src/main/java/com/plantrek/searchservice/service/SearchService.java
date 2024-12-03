package com.plantrek.searchservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantrek.searchservice.models.dtos.requests.SearchRequest;
import com.plantrek.searchservice.models.dtos.responses.FlightResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchService {

    @Autowired
    private FlightService flightService;

    public FlightResponse searchFlight(SearchRequest request) {

        if (request.getOrigin() == null) {
            log.warn("Origin is empty");
            return null;
        }

        if (request.getDestination() == null) {
            System.out.println("Destination is empty");
            return null;
        }

        boolean hasFlight = flightService.checkFlight(request.getFlightRequest());
        if (!hasFlight) {
            return null;
        }

        return FlightResponse.builder().id("1").price(request.getPriceRange()).build();
    }
}
