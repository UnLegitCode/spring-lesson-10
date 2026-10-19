package ru.unlegit.userservice.repository;

import org.springframework.data.repository.ListCrudRepository;
import ru.unlegit.userservice.user.User;

public interface UserRepository extends ListCrudRepository<User, Integer> {

    boolean existsByEmail(String email);
}