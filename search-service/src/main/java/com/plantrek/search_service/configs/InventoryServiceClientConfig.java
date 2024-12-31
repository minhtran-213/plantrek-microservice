package com.plantrek.search_service.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "inventory-service")
@Data
public class InventoryServiceClientConfig {

    private String baseUrl;
}
