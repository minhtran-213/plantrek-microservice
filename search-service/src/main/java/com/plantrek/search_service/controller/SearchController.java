package com.plantrek.search_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantrek.search_service.models.dtos.requests.SearchRequest;
import com.plantrek.search_service.services.SearchService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/flights")
    public String searchFlights(@Valid @RequestBody SearchRequest request) {
        searchService.searchFlights(request);
        return "get flights";
    }
}
