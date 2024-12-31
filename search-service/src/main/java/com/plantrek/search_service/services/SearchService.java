package com.plantrek.search_service.services;

import com.plantrek.search_service.models.dtos.requests.SearchRequest;

public interface SearchService {

    void searchFlights(SearchRequest request);
}
