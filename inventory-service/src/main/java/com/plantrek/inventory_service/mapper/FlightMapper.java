package com.plantrek.inventory_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import com.plantrek.inventory_service.models.dtos.requests.FlightRequest;
import com.plantrek.inventory_service.models.dtos.responses.FlightResponse;
import com.plantrek.inventory_service.models.entities.FlightEntity;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface FlightMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "airline", source = "request.airline")
    @Mapping(target = "origin", source = "request.origin")
    @Mapping(target = "destination", source = "request.destination")
    @Mapping(target = "duration", source = "request.duration")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    FlightEntity flightRequestToFlightEntity(FlightRequest request);

    @Mapping(target = "id", ignore = true) // Don't modify ID
    @Mapping(target = "createdAt", ignore = true) // Don't modify creation timestamp
    @Mapping(target = "airline", source = "request.airline")
    @Mapping(target = "origin", source = "request.origin")
    @Mapping(target = "destination", source = "request.destination")
    @Mapping(target = "duration", source = "request.duration")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    void updateFlightEntityFromRequest(FlightRequest request, @MappingTarget FlightEntity existingEntity);

    @Mapping(target = "id", ignore = true) // Don't modify ID
    @Mapping(target = "createdAt", ignore = true) // Don't modify creation timestamp
    @Mapping(target = "airline", source = "origin.airline")
    @Mapping(target = "origin", source = "origin.origin")
    @Mapping(target = "destination", source = "origin.destination")
    @Mapping(target = "duration", source = "origin.duration")
    @Mapping(target = "updatedAt", source = "origin.updatedAt")
    FlightResponse entityToResponse(FlightEntity origin);
}