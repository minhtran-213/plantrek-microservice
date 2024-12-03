
package com.plantrek.inventory_service.models.dtos.criterias;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FlightsSearchCriteria {

    private String origin;
    private String destination;
    private String depatureDate;
    private BigDecimal maxPrice;
    private String airline;
    private Integer seatsRequired;
}
