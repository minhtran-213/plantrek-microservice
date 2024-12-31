package com.plantrek.search_service.models.dtos.requests.external;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightSearchCriteria {

    private String origin;
    private String destination;
    private String depatureDate;
    private BigDecimal maxPrice;
    private String airline;
    private Integer seatsRequired;
}
