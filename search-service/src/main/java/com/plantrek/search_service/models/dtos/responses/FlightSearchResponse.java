package com.plantrek.search_service.models.dtos.responses;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FlightSearchResponse {

    private String id;
    private String airline;
    private String origin;
    private String destination;
    private String duration;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
