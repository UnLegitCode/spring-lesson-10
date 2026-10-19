package ru.unlegit.cleanarchitecture.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    int id;
    String name;
    String email;
    LocalDateTime createdAt;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}