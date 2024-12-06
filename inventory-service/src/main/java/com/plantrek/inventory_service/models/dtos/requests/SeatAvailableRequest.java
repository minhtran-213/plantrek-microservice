package com.plantrek.inventory_service.models.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SeatAvailableRequest {

    @NotEmpty(message = "Schedule Id should not be empty")
    private String scheduleId;

    @Min(value = 0, message = "Available seats cannot be less than 1")
    private Integer availableSeats;
}
