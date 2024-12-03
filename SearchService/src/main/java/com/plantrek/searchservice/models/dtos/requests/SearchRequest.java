package com.plantrek.searchservice.models.dtos.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchRequest {

    @NotEmpty(message = "Origin is empty")
    private String origin;

    @NotEmpty(message = "Destination is empty")
    private String destination;

    @NotEmpty(message = "Departure date is empty")
    private String departureDate;

    private String returnDate;
    
    @NotEmpty(message = "Trip type is empty")
    private String tripType;

    private SearchFilterRequest filters;
}
