package ru.unlegit.cleanarchitecture.application.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.unlegit.cleanarchitecture.application.dto.UserDto;
import ru.unlegit.cleanarchitecture.application.mapper.UserMapper;
import ru.unlegit.cleanarchitecture.domain.exception.UserEmailAlreadyTakenException;
import ru.unlegit.cleanarchitecture.domain.exception.UserNotFoundException;
import ru.unlegit.cleanarchitecture.domain.model.User;
import ru.unlegit.cleanarchitecture.domain.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public List<UserDto> listUsers() {
        return userMapper.modelToDto(userRepository.findAll());
    }

    public UserDto createUser(String name, String email) {
        if (userRepository.existsByEmail(email)) {
            throw new UserEmailAlreadyTakenException(email);
        }

        var user = userRepository.save(new User(name, email));

        return userMapper.modelToDto(user);
    }

    public void checkExists(int userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
    }
}