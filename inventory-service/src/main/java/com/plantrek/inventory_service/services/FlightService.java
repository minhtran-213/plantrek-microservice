package com.plantrek.inventory_service.services;

import com.plantrek.inventory_service.models.dtos.criterias.FlightsSearchCriteria;
import com.plantrek.inventory_service.models.dtos.requests.FlightRequest;
import com.plantrek.inventory_service.models.dtos.responses.FlightResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlightService {

    void addOrUpdateFlight(FlightRequest request);

    Page<FlightResponse> findAll(FlightsSearchCriteria criteria, Pageable pageable);
}
