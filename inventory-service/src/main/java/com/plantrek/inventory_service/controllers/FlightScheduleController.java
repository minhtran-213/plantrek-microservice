package com.plantrek.inventory_service.controllers;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.plantrek.inventory_service.models.dtos.requests.FlightScheduleRequest;
import com.plantrek.inventory_service.models.dtos.requests.SeatAvailableRequest;
import com.plantrek.inventory_service.models.dtos.responses.ScheduleWithFlightResponse;
import com.plantrek.inventory_service.services.FlightScheduleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class FlightScheduleController {

    private final FlightScheduleService flightScheduleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrUpdateFlightSchedule(@RequestBody FlightScheduleRequest request) {
        flightScheduleService.addOrUpdateFlightSchedule(request);
    }

    @PutMapping("/availabilities")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSeatAvailabilities(@Valid @RequestBody SeatAvailableRequest request) {
        flightScheduleService.updateSeatAvailabilities(request);
    }

    @GetMapping("/{flightId}")
    public List<ScheduleWithFlightResponse> getScheduleWithFlightResponse(@PathVariable String flightId) {
        return flightScheduleService.getScheduleWithFlightResponses(flightId);
    }
}
