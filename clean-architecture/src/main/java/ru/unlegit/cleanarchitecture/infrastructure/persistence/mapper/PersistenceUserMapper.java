package ru.unlegit.cleanarchitecture.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import ru.unlegit.cleanarchitecture.domain.model.User;
import ru.unlegit.cleanarchitecture.infrastructure.persistence.model.JpaUser;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersistenceUserMapper {

    User jpaToDomain(JpaUser user);

    List<User> jpaToDomain(List<JpaUser> users);

    JpaUser domainToJpa(User user);
}