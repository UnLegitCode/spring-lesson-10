package ru.unlegit.cleanarchitecture.adaptation.mapper;

import org.mapstruct.Mapper;
import ru.unlegit.cleanarchitecture.application.dto.UserDto;
import ru.unlegit.cleanarchitecture.domain.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructUserMapper {

    UserDto modelToDto(User model);

    List<UserDto> modelToDto(List<User> models);
}