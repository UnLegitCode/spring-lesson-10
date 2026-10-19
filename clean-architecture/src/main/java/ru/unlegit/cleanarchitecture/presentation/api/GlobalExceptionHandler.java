package ru.unlegit.cleanarchitecture.presentation.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.unlegit.cleanarchitecture.domain.exception.UserEmailAlreadyTakenException;
import ru.unlegit.cleanarchitecture.domain.exception.UserNotFoundException;
import ru.unlegit.cleanarchitecture.presentation.dto.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorInfo handleNotFound(Exception exception) {
        return new ErrorInfo(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserEmailAlreadyTakenException.class)
    public ErrorInfo handleConflict(Exception exception) {
        return new ErrorInfo(exception.getMessage());
    }
}