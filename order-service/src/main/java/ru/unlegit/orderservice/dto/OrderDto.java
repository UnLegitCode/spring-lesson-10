package ru.unlegit.orderservice.dto;

import java.time.LocalDateTime;

public record OrderDto(int id, int userId, int productId, LocalDateTime createdAt) {}