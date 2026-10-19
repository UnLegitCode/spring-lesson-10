package ru.unlegit.cleanarchitecture.application.mapper;

import ru.unlegit.cleanarchitecture.application.dto.UserDto;
import ru.unlegit.cleanarchitecture.domain.model.User;

import java.util.List;

public interface UserMapper {

    UserDto modelToDto(User model);

    List<UserDto> modelToDto(List<User> models);
}