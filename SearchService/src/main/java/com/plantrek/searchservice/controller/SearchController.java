package com.plantrek.searchservice.controller;

import com.plantrek.searchservice.models.dtos.requests.SearchRequest;
import com.plantrek.searchservice.models.dtos.responses.FlightResponse;
import com.plantrek.searchservice.service.SearchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    @Autowired
    private SearchService service;

    @PostMapping("/flights")
    public void searchFlights(@Valid @RequestBody SearchRequest request) {

        
    }

    @GetMapping
    public String getString(@RequestParam String param) {
        return "String";
    }
    
}
