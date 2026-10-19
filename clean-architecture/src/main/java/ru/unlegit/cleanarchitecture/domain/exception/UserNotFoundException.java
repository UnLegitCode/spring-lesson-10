package ru.unlegit.cleanarchitecture.domain.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id) {
        super("Пользователь с ID '%d' не найден".formatted(id));
    }
}