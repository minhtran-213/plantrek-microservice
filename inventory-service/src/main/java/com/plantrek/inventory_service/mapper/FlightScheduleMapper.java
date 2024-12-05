package com.plantrek.inventory_service.mapper;

import com.plantrek.inventory_service.models.dtos.requests.FlightScheduleRequest;
import com.plantrek.inventory_service.models.entities.FlightScheduleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface FlightScheduleMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "flightId", source = "request.flightId")
    @Mapping(target = "departureTime", source = "request.departureTime")
    @Mapping(target = "arrivalTime", source = "request.arrivalTime")
    FlightScheduleEntity fromRequestToEntity(FlightScheduleRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "flightId", source = "request.flightId")
    @Mapping(target = "departureTime", source = "request.departureTime")
    @Mapping(target = "arrivalTime", source = "request.arrivalTime")
    void mapFromRequestToEntity(FlightScheduleRequest request, @MappingTarget FlightScheduleEntity entity);
}
