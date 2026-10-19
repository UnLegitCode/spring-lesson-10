package ru.unlegit.cleanarchitecture.infrastructure.persistence.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JpaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false, unique = true)
    String email;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    LocalDateTime createdAt;
}