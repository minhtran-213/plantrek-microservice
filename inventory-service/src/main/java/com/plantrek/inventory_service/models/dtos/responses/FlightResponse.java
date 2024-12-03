package com.plantrek.inventory_service.models.dtos.responses;

import lombok.Data;

@Data
public class FlightResponse {

    private String id;
    private String airline;
    private String origin;
    private String destination; 
    private String duration;
    private String createdAt;
    private String updatedAt;
}
