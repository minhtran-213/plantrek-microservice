package com.plantrek.inventory_service.services;

import java.util.List;

import com.plantrek.inventory_service.models.dtos.requests.FlightScheduleRequest;
import com.plantrek.inventory_service.models.dtos.requests.SeatAvailableRequest;
import com.plantrek.inventory_service.models.dtos.responses.ScheduleWithFlightResponse;

public interface FlightScheduleService {

    void addOrUpdateFlightSchedule(FlightScheduleRequest request);
    void updateSeatAvailabilities(SeatAvailableRequest request);
    List<ScheduleWithFlightResponse> getScheduleWithFlightResponses(String flightId);
}
