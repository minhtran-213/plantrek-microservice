package com.plantrek.search_service.models.dtos.requests;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SearchFilterRequest {

    private String airline;
    private BigDecimal maxPrice;
}
