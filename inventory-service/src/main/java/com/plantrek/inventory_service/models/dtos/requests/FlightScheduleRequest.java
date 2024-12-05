package com.plantrek.inventory_service.models.dtos.requests;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightScheduleRequest {

    private String id;

    @NotEmpty(message = "Flight id should not be empty")
    private String flightId;

    @NotNull
    @Future(message = "Departure time should be in the future")
    private LocalDateTime departureTime;

    @NotNull
    @Future(message = "Arrival time should be in the future")
    private LocalDateTime arrivalTime;
}
