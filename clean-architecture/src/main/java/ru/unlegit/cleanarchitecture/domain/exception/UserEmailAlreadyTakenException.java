package ru.unlegit.cleanarchitecture.domain.exception;

public class UserEmailAlreadyTakenException extends RuntimeException {

    public UserEmailAlreadyTakenException(String email) {
        super("Email-адрес '%s' уже занят другим пользователем".formatted(email));
    }
}