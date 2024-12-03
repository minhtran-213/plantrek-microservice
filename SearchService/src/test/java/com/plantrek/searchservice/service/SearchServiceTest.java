package com.plantrek.searchservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.plantrek.searchservice.models.dtos.requests.SearchRequest;
import com.plantrek.searchservice.models.dtos.responses.FlightResponse;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @Mock
    FlightService flightService;

    @InjectMocks
    SearchService searchService;


    @Test
    void testSearchFlightWhenFlightRequestNullThenReturnNull() {
        //given
        SearchRequest request = SearchRequest.builder()
                .origin("SGN")
                .destination("HN")
                .flightRequest(null)
                .build();

        Mockito
                .when(flightService.checkFlight(request.getFlightRequest()))
                .thenReturn(false);

        //when
        FlightResponse actual = searchService.searchFlight(request);

        //then
        assertThat(actual).isNull();
    }
}
