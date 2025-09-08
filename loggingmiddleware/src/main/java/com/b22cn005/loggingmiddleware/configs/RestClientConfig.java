package com.b22cn005.loggingmiddleware.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@SuppressWarnings("ALL")
@Component
public class RestClientConfig {

    private final String BASE_URL = "http://20.244.56.144/evaluation-service/logs";

    @Bean
    RestClient getRestClient() {
        return RestClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }
}
