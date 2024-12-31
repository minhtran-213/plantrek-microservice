package com.plantrek.search_service.models.dtos.requests;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SearchRequest {

    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime returnTime;
    private SearchFilterRequest filters;
}
