package com.plantrek.inventory_service.controllers;

import com.plantrek.inventory_service.models.dtos.criterias.FlightsSearchCriteria;
import com.plantrek.inventory_service.models.dtos.requests.FlightRequest;
import com.plantrek.inventory_service.models.dtos.responses.FlightResponse;
import com.plantrek.inventory_service.services.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightsController {

    private final FlightService flightService;

    @GetMapping
    public Page<FlightResponse> getFlights(FlightsSearchCriteria criteria, Pageable pageable) {
        return flightService.findAll(criteria, pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrUpdateFlights(@Valid @RequestBody FlightRequest request) {
        flightService.addOrUpdateFlight(request);
    }
}
