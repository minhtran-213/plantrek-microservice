package com.plantrek.inventory_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import com.plantrek.inventory_service.models.dtos.requests.FlightRequest;
import com.plantrek.inventory_service.models.entities.FlightEntity;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface FlightMapper {

    @Mapping(target = "airline", source = "request.airline")
    @Mapping(target = "origin", source = "request.origin")
    @Mapping(target = "destination", source = "request.destination")
    @Mapping(target = "duration", source = "request.duration")
    FlightEntity flightRequestToFlightEntity(FlightRequest request);

    @Mapping(target = "airline", source = "request.airline")
    @Mapping(target = "origin", source = "request.origin")
    @Mapping(target = "destination", source = "request.destination")
    @Mapping(target = "duration", source = "request.duration")
    void updateFlightEntityFromRequest(FlightRequest request, @MappingTarget FlightEntity existingEntity);
}
