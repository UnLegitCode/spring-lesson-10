package ru.unlegit.orderservice.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.unlegit.orderservice.client.UserServiceClient;
import ru.unlegit.orderservice.dto.OrderCreateDto;
import ru.unlegit.orderservice.dto.OrderDto;
import ru.unlegit.orderservice.mapper.OrderMapper;
import ru.unlegit.orderservice.model.Order;
import ru.unlegit.orderservice.repository.OrderRepository;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    UserServiceClient userServiceClient;

    public List<OrderDto> listOrders() {
        return orderMapper.modelToDto(orderRepository.findAll());
    }

    public OrderDto create(OrderCreateDto dto) {
        if (!userServiceClient.exists(dto.userId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        var order = orderRepository.save(new Order(dto.userId(), dto.productId()));

        return orderMapper.modelToDto(order);
    }
}