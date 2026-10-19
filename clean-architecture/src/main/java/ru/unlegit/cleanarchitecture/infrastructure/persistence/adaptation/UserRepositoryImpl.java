package ru.unlegit.cleanarchitecture.infrastructure.persistence.adaptation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import ru.unlegit.cleanarchitecture.domain.model.User;
import ru.unlegit.cleanarchitecture.domain.repository.UserRepository;
import ru.unlegit.cleanarchitecture.infrastructure.persistence.mapper.PersistenceUserMapper;
import ru.unlegit.cleanarchitecture.infrastructure.persistence.repository.JpaUserRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserRepositoryImpl implements UserRepository {

    JpaUserRepository jpaRepository;
    PersistenceUserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.jpaToDomain(jpaRepository.findAll());
    }

    @Override
    public Optional<User> findById(int id) {
        return jpaRepository.findById(id)
                .map(userMapper::jpaToDomain);
    }

    @Override
    public User save(User user) {
        var jpaUser = userMapper.domainToJpa(user);

        jpaUser = jpaRepository.save(jpaUser);

        return userMapper.jpaToDomain(jpaUser);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsById(int id) {
        return jpaRepository.existsById(id);
    }
}