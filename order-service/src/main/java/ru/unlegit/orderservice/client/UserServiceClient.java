package ru.unlegit.orderservice.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class UserServiceClient {

    private final RestTemplate restTemplate;

    public UserServiceClient(@Qualifier("userServiceTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean exists(int userId) {
        try {
            restTemplate.getForEntity("/exists/" + userId, Void.class);

            return true;
        } catch (HttpClientErrorException.NotFound exception) {
            return false;
        }
    }
}