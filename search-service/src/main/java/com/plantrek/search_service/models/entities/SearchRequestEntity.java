package com.plantrek.search_service.models.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "search_requests")
@Data
public class SearchRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;
    
    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "trip_type")
    private String tripType;

    @Column(name = "filters")
    private String filters;
}
