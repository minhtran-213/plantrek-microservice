package com.plantrek.search_service.integration;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import com.plantrek.search_service.models.dtos.responses.FlightSearchResponse;

public interface InventoryServiceClient {

    @GetExchange("/flights")
    Page<FlightSearchResponse> getFlights(
        @RequestParam(required = false) String origin,
        @RequestParam(required = false) String destination,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sort
    );
}
