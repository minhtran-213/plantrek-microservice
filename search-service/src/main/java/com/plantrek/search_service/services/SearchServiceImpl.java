package com.plantrek.search_service.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.plantrek.search_service.integration.InventoryServiceClient;
import com.plantrek.search_service.models.dtos.requests.SearchRequest;
import com.plantrek.search_service.models.dtos.requests.external.FlightSearchCriteria;
import com.plantrek.search_service.models.dtos.responses.FlightSearchResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchServiceImpl implements SearchService {

    private final InventoryServiceClient inventoryServiceClient;

    @Override
    public void searchFlights(SearchRequest request) {
        log.info("Start searching flights with origin [{}] and destination [{}]", request.getOrigin(),
                request.getDestination());
        FlightSearchCriteria criteria = FlightSearchCriteria.builder()
                .airline(request.getFilters().getAirline())
                .origin(request.getOrigin())
                .destination(request.getDestination())
                .build();
        Page<FlightSearchResponse> response = inventoryServiceClient.getFlights(request.getOrigin(),
                request.getDestination(), 0, 10, "id, desc");
        log.info("Found flights with size: {}", response.getContent().size());
    }

}
