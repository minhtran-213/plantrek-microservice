package com.plantrek.inventory_service.services;

import com.plantrek.inventory_service.models.dtos.requests.FlightScheduleRequest;

public interface FlightScheduleService {

    void addOrUpdateFlightSchedule(FlightScheduleRequest request);
}
