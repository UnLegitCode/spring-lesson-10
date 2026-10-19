package ru.unlegit.cleanarchitecture.adaptation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.unlegit.cleanarchitecture.application.mapper.UserMapper;
import ru.unlegit.cleanarchitecture.application.service.UserService;
import ru.unlegit.cleanarchitecture.domain.repository.UserRepository;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository, UserMapper userMapper) {
        return new UserService(userRepository, userMapper);
    }
}