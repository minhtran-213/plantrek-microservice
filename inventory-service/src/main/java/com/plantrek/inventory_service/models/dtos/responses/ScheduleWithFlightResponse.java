package com.plantrek.inventory_service.models.dtos.responses;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleWithFlightResponse {

    private String id;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer availableSeats;
    private FlightResponse flightResponse;
}
