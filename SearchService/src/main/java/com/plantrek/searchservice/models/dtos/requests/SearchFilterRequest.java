package com.plantrek.searchservice.models.dtos.requests;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class SearchFilterRequest {

    private BigDecimal maxPrice;

    private List<String> airLine;

    private List<String> departureTimeRange;

    private Integer maxStops;
}
