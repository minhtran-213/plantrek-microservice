package com.plantrek.inventory_service.models.dtos.responses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FlightResponse {

    private String id;
    private String airline;
    private String origin;
    private String destination;
    private String duration;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
