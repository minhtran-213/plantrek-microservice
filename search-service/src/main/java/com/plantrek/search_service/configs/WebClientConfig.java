package com.plantrek.search_service.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.plantrek.search_service.integration.InventoryServiceClient;

@Configuration
public class WebClientConfig {

    @Bean
    public InventoryServiceClient inventoryServiceWebClient(final InventoryServiceClientConfig config) {
        WebClient webClient = WebClient.builder()
                .baseUrl(config.getBaseUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient)).build();
                
        return factory.createClient(InventoryServiceClient.class);
    }
}
