package com.plantrek.inventory_service.services;

import com.plantrek.inventory_service.models.dtos.requests.FlightRequest;

public interface FlightService {
 
    void addOrUpdateFlight(FlightRequest request);
}
