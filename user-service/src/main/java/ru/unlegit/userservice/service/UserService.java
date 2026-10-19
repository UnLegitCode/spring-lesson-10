package ru.unlegit.userservice.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.unlegit.userservice.dto.UserCreateDto;
import ru.unlegit.userservice.dto.UserDto;
import ru.unlegit.userservice.mapper.UserMapper;
import ru.unlegit.userservice.repository.UserRepository;
import ru.unlegit.userservice.user.User;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public List<UserDto> listUsers() {
        return userMapper.modelToDto(userRepository.findAll());
    }

    public UserDto create(UserCreateDto dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        var user = userRepository.save(new User(dto.name(), dto.email()));

        return userMapper.modelToDto(user);
    }

    public void exists(int id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}