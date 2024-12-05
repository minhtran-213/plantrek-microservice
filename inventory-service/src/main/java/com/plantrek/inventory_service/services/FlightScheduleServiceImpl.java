package com.plantrek.inventory_service.services;

import com.plantrek.inventory_service.mapper.FlightScheduleMapper;
import com.plantrek.inventory_service.models.dtos.requests.FlightScheduleRequest;
import com.plantrek.inventory_service.models.entities.FlightEntity;
import com.plantrek.inventory_service.models.entities.FlightScheduleEntity;
import com.plantrek.inventory_service.repositories.FlightScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightScheduleServiceImpl implements FlightScheduleService {

    private final FlightService flightService;
    private final FlightScheduleMapper flightScheduleMapper;
    private final FlightScheduleRepository flightScheduleRepository;

    @Override
    public void addOrUpdateFlightSchedule(FlightScheduleRequest request) {
        FlightEntity flightEntity = flightService.findById(request.getFlightId());

        if (Objects.nonNull(flightEntity)) {
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

}
