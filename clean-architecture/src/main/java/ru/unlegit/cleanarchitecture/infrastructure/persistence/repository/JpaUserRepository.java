package ru.unlegit.cleanarchitecture.infrastructure.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import ru.unlegit.cleanarchitecture.infrastructure.persistence.model.JpaUser;

public interface JpaUserRepository extends ListCrudRepository<JpaUser, Integer> {

    boolean existsByEmail(String email);
}