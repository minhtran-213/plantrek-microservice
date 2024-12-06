package com.plantrek.inventory_service.services;

import com.plantrek.inventory_service.mapper.FlightMapper;
import com.plantrek.inventory_service.mapper.FlightScheduleMapper;
import com.plantrek.inventory_service.models.dtos.requests.FlightScheduleRequest;
import com.plantrek.inventory_service.models.dtos.requests.SeatAvailableRequest;
import com.plantrek.inventory_service.models.dtos.responses.FlightResponse;
import com.plantrek.inventory_service.models.dtos.responses.ScheduleWithFlightResponse;
import com.plantrek.inventory_service.models.entities.FlightEntity;
import com.plantrek.inventory_service.models.entities.FlightScheduleEntity;
import com.plantrek.inventory_service.repositories.FlightScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightScheduleServiceImpl implements FlightScheduleService {

    private final FlightService flightService;
    private final FlightScheduleMapper flightScheduleMapper;
    private final FlightScheduleRepository flightScheduleRepository;
    private final FlightMapper flightMapper;

    @Override
    public void addOrUpdateFlightSchedule(FlightScheduleRequest request) {
        FlightEntity flightEntity = flightService.findById(request.getFlightId());

        if (Objects.isNull(flightEntity)) {
            log.warn("No existed flight found with id {}", request.getFlightId());
            return;
        }

        FlightScheduleEntity entity;
        if (StringUtils.isNotEmpty(request.getId())) {
            log.info("Start searching existing flight schedule for flight id: {}", request.getFlightId());
            entity = flightScheduleRepository.findById(request.getId()).orElse(null);
            if (Objects.nonNull(entity)) {
                flightScheduleMapper.mapFromRequestToEntity(request, entity);
            }
        } else {
            entity = flightScheduleMapper.fromRequestToEntity(request);
        }

        flightScheduleRepository.save(entity);
    }

    @Override
    public void updateSeatAvailabilities(SeatAvailableRequest request) {
        var existedFlightSchedule = flightScheduleRepository.findById(request.getScheduleId());

        if (existedFlightSchedule.isEmpty()) {
            log.warn("There are no existed flight schedule");
            return;
        }

        var existedlightScheduleEntity = existedFlightSchedule.get();
        existedlightScheduleEntity.setAvailableSeats(request.getAvailableSeats());
        flightScheduleRepository.save(existedlightScheduleEntity);
    }

    @Override
    public List<ScheduleWithFlightResponse> getScheduleWithFlightResponses(String flightId) {
        FlightEntity flightEntity = flightService.findById(flightId);
        if (Objects.isNull(flightEntity)) {
            log.warn("No existed flight with id {}", flightId);
            return new ArrayList<>();
        }

        List<FlightScheduleEntity> schedules = flightScheduleRepository.findByFlightId(flightId);

        return schedules.stream().map(entity -> {
            var response = ScheduleWithFlightResponse.builder()
            .id(entity.getId())
            .arrivalTime(entity.getArrivalTime())
            .availableSeats(entity.getAvailableSeats())
            .departureTime(entity.getDepartureTime())
            .build();
            FlightResponse flightResponse = flightMapper.entityToResponse(flightEntity);
            flightResponse.setId(flightId);
            response.setFlightResponse(flightResponse);
            return response;
        }).toList();
    }

}
