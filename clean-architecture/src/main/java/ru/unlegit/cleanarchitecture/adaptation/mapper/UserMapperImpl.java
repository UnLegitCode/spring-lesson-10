package ru.unlegit.cleanarchitecture.adaptation.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.unlegit.cleanarchitecture.application.dto.UserDto;
import ru.unlegit.cleanarchitecture.application.mapper.UserMapper;
import ru.unlegit.cleanarchitecture.domain.model.User;

import java.util.List;

@Component
@AllArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final MapStructUserMapper mapStructUserMapper;

    @Override
    public UserDto modelToDto(User model) {
        return mapStructUserMapper.modelToDto(model);
    }

    @Override
    public List<UserDto> modelToDto(List<User> models) {
        return mapStructUserMapper.modelToDto(models);
    }
}