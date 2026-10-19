package ru.unlegit.orderservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestClientConfiguration {

    private static RestTemplate createRestTemplate(RestTemplateBuilder builder, String serviceAddress) {
        return builder
                .baseUri("http://%s/api/users".formatted(serviceAddress))
                .connectTimeout(Duration.ofSeconds(3))
                .readTimeout(Duration.ofSeconds(3))
                .build();
    }

    @Bean("userServiceTemplate")
    public RestTemplate restTemplate(
            RestTemplateBuilder builder,
            @Value("${service.user.address}") String userServiceAddress
    ) {
         return createRestTemplate(builder, userServiceAddress);
    }
}