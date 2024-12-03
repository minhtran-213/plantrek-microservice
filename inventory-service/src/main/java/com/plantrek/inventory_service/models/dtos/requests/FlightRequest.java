package com.plantrek.inventory_service.models.dtos.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class FlightRequest {

    @NotEmpty(message = "Airline should not be empty")
    private String airline;
    @NotEmpty(message = "Origin should not be empty")
    private String origin;

    @NotEmpty(message = "Destination should not be empty")
    private String destination;

    @NotEmpty(message = "Duration should not be empty")
    private String duration;
}
