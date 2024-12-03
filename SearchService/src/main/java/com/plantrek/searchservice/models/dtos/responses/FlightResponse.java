package com.plantrek.searchservice.models.dtos.responses;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class FlightResponse {
    private String id;
    private BigDecimal price;
}
