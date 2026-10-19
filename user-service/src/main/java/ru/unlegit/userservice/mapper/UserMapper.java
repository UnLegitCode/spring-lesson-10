package ru.unlegit.userservice.mapper;

import org.mapstruct.Mapper;
import ru.unlegit.userservice.dto.UserDto;
import ru.unlegit.userservice.user.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto modelToDto(User model);

    List<UserDto> modelToDto(List<User> models);
}