package ru.unlegit.cleanarchitecture.domain.repository;

import ru.unlegit.cleanarchitecture.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    Optional<User> findById(int id);

    User save(User user);

    boolean existsByEmail(String email);

    boolean existsById(int id);
}